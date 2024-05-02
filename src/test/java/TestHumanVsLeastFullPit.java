import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestHumanVsLeastFullPit {

    @Test
    @DisplayName("test game (human vs leastFullPit)")
    public void testGame() {

        Game game = GameFactory.createGame("Human", "leastFullPit", "human", "leastFullPit", true, true);
        game.start();

        int winnerPlayerNumber = game.getWinnerPlayerNumber();

        Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);
    }

}
