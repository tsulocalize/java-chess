package chess.machine;

import chess.domain.chessBoard.ChessBoard;
import chess.view.OutputView;

public class Start implements Command {

    private static final String INPUT_COMMAND = "start";

    private Start(String input) {
        if (!input.equals(INPUT_COMMAND)) {
            throw new IllegalArgumentException("시작 명령이 아닙니다");
        }
    }

    public static Start of(String input) {
        return new Start(input);
    }

    @Override
    public void conductCommand(ChessBoard chessBoard, OutputView outputView) {
        chessBoard.startGame();
        outputView.printChessBoard(chessBoard);
    }
}
