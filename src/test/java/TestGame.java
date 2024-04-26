import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestGame {
    @Test
    @DisplayName("test game")
    public void testGame() {
        //Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);

        int p1wins = 0;
        int p2wins = 0;
        int ties = 0;

        for(int i = 0; i < 100; i++) {

            Game game = GameFactory.createGame("random", "random", "random", "random", false, false);
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
