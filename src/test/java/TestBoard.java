import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBoard {
    @Test
    @DisplayName("test game")

    public void testBoardClone() {
        Player player1 = new Player("A", 1);
        Player player2 = new Player("B", 2);

        Board board = new Board(player1, player2);
        int count = board.getPitCount(player1, 0);

        Board boardCopy = board.copy();

        boardCopy.setPitCount(player1, 0, 99);
        int copyCount = boardCopy.getPitCount(player1, 0);

        int newCount = board.getPitCount(player1, 0);

        Assertions.assertTrue(newCount == count );
        Assertions.assertEquals(99, copyCount);
    }

}
