package chess.domain.chessBoard;

import chess.domain.piece.*;

import java.util.ArrayList;
import java.util.List;

public class PieceGenerator {

    public static List<Piece> makeSpecialPieces(Color color) {
        return List.of(
                new Rook(color),
                new Knight(color),
                new Bishop(color),
                new Queen(color),
                new King(color),
                new Bishop(color),
                new Knight(color),
                new Rook(color)
        );
    }

    public static List<Piece> makePawnPieces(Color color, int amount) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            pieces.add(new Pawn(color));
        }
        return pieces;
    }
}
