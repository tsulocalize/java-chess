package domain;

import domain.board.Board;
import domain.board.BoardCreator;
import domain.piece.Piece;
import domain.position.Position;

public class Chess {

    private final Board board;

    public Chess() {
        board = new BoardCreator().create();
    }

    public void movePiece(Position sourcePosition, Position targetPosition) {
        if (canMove(sourcePosition, targetPosition) || board.canAttack(sourcePosition, targetPosition)) {
            Piece sourcePiece = board.findPieceByPosition(sourcePosition);
            board.placePieceByPosition(sourcePiece, targetPosition);
            // 위 두 줄에서 Piece를 가져오지 말고 board가 알아서 하도록 시키는 건 어때요?

            board.displacePieceByPosition(sourcePosition);
        }
    }

    private boolean canMove(Position sourcePosition, Position targetPosition) {
        return board.canMove(sourcePosition, targetPosition)
                && board.isNotBlocked(sourcePosition, targetPosition);
    }

    public Board getBoard() {
        return board;
    }
}
