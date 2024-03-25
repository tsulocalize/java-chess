package chess.domain.chessBoard;

import chess.domain.chessBoard.generator.ChessPieceGenerator;
import chess.domain.chessBoard.generator.PieceGenerator;
import chess.domain.chessBoard.generator.SpaceGenerator;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;
import chess.domain.position.File;
import chess.domain.position.Position;
import chess.domain.position.Rank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class TestSpaceGenerator implements SpaceGenerator {

    private static final PieceGenerator pieceGenerator = new ChessPieceGenerator();

    @Override
    public List<Space> generateSpaces() {
        List<Space> spaces = new ArrayList<>();
        Iterator<Piece> pieceIterator = makeAllPieces().iterator();

        for (Rank rank : backwardRanks()) {
            spaces.addAll(makeLineSpaces(rank, pieceIterator));
        }
        return spaces;
    }

    private List<Piece> makeAllPieces() {
        List<Piece> pieces = new ArrayList<>();

        pieces.addAll(pieceGenerator.makePawnPieces(Color.BLACK, 1));
        pieces.addAll(pieceGenerator.makePawnPieces(Color.WHITE, 1));
        pieces.addAll(pieceGenerator.makeEmptyPieces(6));

        pieces.addAll(pieceGenerator.makePawnPieces(Color.BLACK, 1));
        pieces.addAll(pieceGenerator.makePawnPieces(Color.WHITE, 1));
        pieces.addAll(pieceGenerator.makeEmptyPieces(6));

        pieces.addAll(pieceGenerator.makeEmptyPieces(1));
        pieces.addAll(pieceGenerator.makePawnPieces(Color.WHITE, 1));
        pieces.addAll(pieceGenerator.makeEmptyPieces(6));

        pieces.addAll(pieceGenerator.makeEmptyPieces(40));

        return pieces;
    }

    private List<Rank> backwardRanks() {
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        return ranks;
    }

    private List<Space> makeLineSpaces(Rank rank, Iterator<Piece> pieceIterator) {
        List<Space> rankSpaces = new ArrayList<>();
        for (File file : File.values()) {
            rankSpaces.add(new Space(pieceIterator.next(), new Position(file, rank)));
        }
        return rankSpaces;
    }
}
