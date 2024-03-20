package chess.domain.piece;

import chess.domain.position.Position;

public class Queen extends Piece {
    public Queen(Team team) {
        super(team);
    }

    @Override
    public boolean canMove(Position start, Position destination) {
        if (start.isStraightWith(destination) || start.isDiagonalWith(destination)) {
            return true;
        }
        return false;
    }
}
