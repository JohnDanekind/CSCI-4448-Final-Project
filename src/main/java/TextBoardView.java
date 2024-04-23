import javax.swing.*;
import java.awt.*;

public class TextBoardView implements Viewer{
    Viewable board;
    int moveCount;

    public TextBoardView(Viewable board) {
        this.board = board;
        moveCount = 1;
    }

    public int update(int event) {

        if(event == Event.WAITING_FOR_MOVE) {
            // do nothing
        }

        if(event == Event.MOVE) {
            // do nothing
        }

        if(event == Event.MOVE_COMPLETE) {
            Player p1 = board.getPlayer(1);
            Player p2 = board.getPlayer(2);


            String message = moveCount++ + ": board state after ";
            message += board.getCurrentPlayer().getName() + "'s move at pit ";
            message += board.getCurrentMove();
            message += "\n   ";
            for (int i = 5; i >= 0; i--) {
                message += String.format("%2d ", board.getPitCount(p2, i));
            }
            message += String.format("\n%2d ----------------- %2d\n   ", board.getMancalaCount(p2), board.getMancalaCount(p1));

            for (int i = 0; i < 6; i++) {
                message += String.format("%2d ", board.getPitCount(p1, i));
            }

            message += "\n";

            // print the message
            System.out.println(message);

            if(board.isWinner()) {
                System.out.println("**** Game over ****");
                System.out.println(board.getWinner().getName() + " is the winner!\n\n");
            }
        }

        return 0;
    }
}
