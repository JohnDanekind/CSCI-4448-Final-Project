import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void move() {
        // create players
        Player player1 = new Player("Player A", 1);
        Player player2 = new Player("Player B", 2);

        // create board
        Board board = new Board(player1, player2);

        // Perform a move for player 1
        board.move(player1, 0);

        // assert that the stone count in the specified pit has changed
        assertEquals(0, board.getPitCount(player1, 0));
    }

    @Test
    void getPitCount() {
        // create players
        Player player1 = new Player("Player A", 1);
        Player player2 = new Player("Player B", 2);

        // create board
        Board board = new Board(player1, player2);

        // Initially, all pit counts should be 4
        for (int i = 0; i < Board.PITCOUNT; i++) {
            assertEquals(4, board.getPitCount(player1, i));
            assertEquals(4, board.getPitCount(player2, i));
        }
    }

    @Test
    void getMancalaCount() {
        // Create players
        Player player1 = new Player("Player A", 1);
        Player player2 = new Player("Player B", 2);

        // Create board
        Board board = new Board(player1, player2);

        // Initially, Mancala counts should be 0
        assertEquals(0, board.getMancalaCount(player1));
        assertEquals(0, board.getMancalaCount(player2));
    }


    @Test
    void isWinner() {
        // Create players
        Player player1 = new Player("Player A", 1);
        Player player2 = new Player("Player B", 2);

        // Create board
        Board board = new Board(player1, player2);

        // Initially, there should be no winner
        assertFalse(board.isWinner());

        // Play the game until all pits of player 1 are empty
        while (!board.isWinner()) {
            for (int i = 0; i < Board.PITCOUNT; i++) {
                board.move(player1, i);
            }
        }

        // Check which Mancala has more stones
        int p1MancalaStones = board.getMancalaCount(player1);
        int p2MancalaStones = board.getMancalaCount(player2);

        // Declare the winner based on Mancala stone counts
        Player winner;
        if (p1MancalaStones > p2MancalaStones) {
            winner = player1;
        } else if (p1MancalaStones < p2MancalaStones) {
            winner = player2;
        } else {
            winner = null; // Tie
        }

        // Check if the correct winner is declared
        assertEquals(winner, board.getWinner());
    }
}