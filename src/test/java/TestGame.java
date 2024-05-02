import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestGame {
    @Test
    @DisplayName("minMax vs random")
    public void testGame() {
        // Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);

        int p1wins = 0;
        int p2wins = 0;
        int ties = 0;

        for(int i = 0; i < 100; i++) {

            Game game = GameFactory.createGame("minMax", "random", "minMax", "random", false, false);
            game.start();

            int winnerPlayerNumber = game.getWinnerPlayerNumber();

            if (winnerPlayerNumber == 1) {
                p1wins++;
            }

            if (winnerPlayerNumber == 2) {
                p2wins++;
            }

            if (winnerPlayerNumber == 0) {
                ties++;
            }
            Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);

        }

        System.out.printf("p1 wins: %d, p2 wins: %d, ties: %d\n", p1wins, p2wins, ties);

    }
    @Test
    @DisplayName("test random vs random ")
    public void testRandomVsRandom() {
        // Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);

        int p1wins = 0;
        int p2wins = 0;
        int ties = 0;

        for(int i = 0; i < 100; i++) {

            Game game = GameFactory.createGame("random1", "random2", "random", "random", false, false);
            game.start();

            int winnerPlayerNumber = game.getWinnerPlayerNumber();

            if (winnerPlayerNumber == 1) {
                p1wins++;
            }

            if (winnerPlayerNumber == 2) {
                p2wins++;
            }

            if (winnerPlayerNumber == 0) {
                ties++;
            }
            Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);

        }

        System.out.printf("p1 wins: %d, p2 wins: %d, ties: %d\n", p1wins, p2wins, ties);

    }
    @Test
    @DisplayName("test random vs fullestPit ")
    public void testRandomVsFullestPit() {
        // Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);

        int p1wins = 0;
        int p2wins = 0;
        int ties = 0;

        for(int i = 0; i < 100; i++) {

            Game game = GameFactory.createGame("random", "fullestPit", "random", "fullestPit", false, false);
            game.start();

            int winnerPlayerNumber = game.getWinnerPlayerNumber();

            if (winnerPlayerNumber == 1) {
                p1wins++;
            }

            if (winnerPlayerNumber == 2) {
                p2wins++;
            }

            if (winnerPlayerNumber == 0) {
                ties++;
            }
            Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);

        }

        System.out.printf("p1 wins: %d, p2 wins: %d, ties: %d\n", p1wins, p2wins, ties);

    }
    @Test
    @DisplayName("test random vs leastFullpit ")
    public void testRandomVsLeastFullPit() {
        // Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);

        int p1wins = 0;
        int p2wins = 0;
        int ties = 0;

        for(int i = 0; i < 100; i++) {

            Game game = GameFactory.createGame("random", "leastFullPit", "random", "leastFullPit", false, false);
            game.start();

            int winnerPlayerNumber = game.getWinnerPlayerNumber();

            if (winnerPlayerNumber == 1) {
                p1wins++;
            }

            if (winnerPlayerNumber == 2) {
                p2wins++;
            }

            if (winnerPlayerNumber == 0) {
                ties++;
            }
            Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);

        }

        System.out.printf("p1 wins: %d, p2 wins: %d, ties: %d\n", p1wins, p2wins, ties);

    }
    @Test
    @DisplayName("test fullestPit vs fullestPit ")
    public void testFullestPitVsFullestPit() {
        // Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);

        int p1wins = 0;
        int p2wins = 0;
        int ties = 0;

        for(int i = 0; i < 100; i++) {

            Game game = GameFactory.createGame("fullestPit1", "fullestPit2", "fullestPit", "fullestPit", false, false);
            game.start();

            int winnerPlayerNumber = game.getWinnerPlayerNumber();

            if (winnerPlayerNumber == 1) {
                p1wins++;
            }

            if (winnerPlayerNumber == 2) {
                p2wins++;
            }

            if (winnerPlayerNumber == 0) {
                ties++;
            }
            Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);

        }

        System.out.printf("p1 wins: %d, p2 wins: %d, ties: %d\n", p1wins, p2wins, ties);

    }
    @Test
    @DisplayName("test fullest vs leastFull ")
    public void testFullestVsleastFull() {
        // Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);

        int p1wins = 0;
        int p2wins = 0;
        int ties = 0;

        for(int i = 0; i < 100; i++) {

            Game game = GameFactory.createGame("fullestPit", "leastFull", "fullestPit", "leastFullPit", false, false);
            game.start();

            int winnerPlayerNumber = game.getWinnerPlayerNumber();

            if (winnerPlayerNumber == 1) {
                p1wins++;
            }

            if (winnerPlayerNumber == 2) {
                p2wins++;
            }

            if (winnerPlayerNumber == 0) {
                ties++;
            }
            Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);

        }

        System.out.printf("p1 wins: %d, p2 wins: %d, ties: %d\n", p1wins, p2wins, ties);

    }

}
