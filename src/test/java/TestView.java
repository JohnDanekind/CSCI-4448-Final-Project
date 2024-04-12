import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
public class TestView {

    @Test
    @DisplayName("Test board view")
    public void testView() {
        Player player1 = new Player("P1", 1);
        Player player2 = new Player("P2", 2);

        Board board = new Board(player1, player2);
        BoardView boardView = new BoardView(board);
        board.addViewer(boardView);

        Assertions.assertTrue(true);
    }

}
