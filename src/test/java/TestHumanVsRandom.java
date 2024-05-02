import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestHumanVsRandom {

    @Test
    @DisplayName("test game (human vs random)")
    public void testGame() {

        Game game = GameFactory.createGame("Human", "random", "human", "random", true, true);
        game.start();

        int winnerPlayerNumber = game.getWinnerPlayerNumber();

        Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);
    }

}


