import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestHumanVsMinmax {
    @Test
    @DisplayName("test game (human vs minMax)")
    public void testGame() {

        Game game = GameFactory.createGame("Human", "minMax", "human", "minMax", true, true);
        game.start();

        int winnerPlayerNumber = game.getWinnerPlayerNumber();

        Assertions.assertTrue(winnerPlayerNumber == 0 || winnerPlayerNumber == 1 || winnerPlayerNumber == 2);
    }
}







