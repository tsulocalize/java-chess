package chess.domain.chessBoard;

import chess.domain.chessBoard.generator.SpaceGenerator;
import chess.domain.piece.Color;
import chess.domain.position.File;
import chess.domain.position.Position;
import java.util.Arrays;
import java.util.List;

public class ChessBoard {

    private final List<Space> spaces;
    private Turn turn;

    public ChessBoard(SpaceGenerator spaceGenerator) {
        this.spaces = spaceGenerator.generateSpaces();
        this.turn = Turn.notPlayingGame();
    }

    public void move(Position from, Position to) {
        validateActiveGame();
        Space fromSpace = findSpace(from);
        Space toSpace = findSpace(to);
        validateTurn(fromSpace);
        fromSpace.movePiece(toSpace, spaces);
        turn = turn.oppositeTurn();
    }

    private void validateActiveGame() {
        if (isActive()) {
            return;
        }
        throw new IllegalStateException("게임이 활성화되지 않았습니다");
    }

    private void validateTurn(Space fromSpace) {
        if (fromSpace.isValidTurn(turn)) {
            return;
        }
        throw new IllegalStateException("상대 플레이어의 차례입니다");
    }

    private Space findSpace(Position position) {
        return spaces.stream()
                .filter(space -> space.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 Space가 없습니다"));
    }

    public void startGame() {
        turn = Turn.firstTurn();
    }

    public void endGame() {
        turn = Turn.notPlayingGame();
    }

    public boolean isActive() {
        return turn.isActive();
    }

    public BoardScore calculateScore(Color color) {
        return Arrays.stream(File.values())
                .map(file -> calculateScoreInFile(color, file))
                .map(BoardScore::create)
                .reduce(BoardScore::concat)
                .orElse(BoardScore.zero());
    }

    private FileScore calculateScoreInFile(Color color, File file) {
        return spaces.stream()
                .filter(space -> space.isSameFile(file))
                .filter(space -> space.hasColor(color))
                .map(space -> FileScore.create(file, space))
                .reduce(FileScore::concat)
                .orElse(FileScore.zero(file));
    }

    public List<String> showBoard() {
        return spaces.stream()
                .map(Space::pieceCharacter)
                .toList();
    }
}
