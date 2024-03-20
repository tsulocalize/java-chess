package domain;

public class King extends Piece {

    public King(Side side) {
        super(side);
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
