package chess.domain.piece;

public enum Side {

    BLACK,
    WHITE,
    EMPTY,
    ;

    public boolean isBlack() {
        return this == BLACK;
    }

    public boolean isWhite() {
        return this == WHITE;
    }

    public Side opponent() {
        if (isBlack()) {
            return WHITE;
        }
        if (isWhite()) {
            return BLACK;
        }
        return EMPTY;
    }

    public boolean isSame(Side side) {
        return this == side;
    }
}
