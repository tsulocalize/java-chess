package chess.machine;

import chess.domain.chessBoard.ChessBoard;
import chess.view.OutputView;

public class End implements Command {

    private static final String INPUT_COMMAND = "end";

    private End(String input) {
        if (!input.equals(INPUT_COMMAND)) {
            throw new IllegalArgumentException("종료 명령이 아닙니다");
        }
    }

    public static End of(String input) {
        return new End(input);
    }

    @Override
    public void conductCommand(ChessBoard chessBoard, OutputView outputView) {
        chessBoard.endGame();
        outputView.printChessBoard(chessBoard);
    }
}
