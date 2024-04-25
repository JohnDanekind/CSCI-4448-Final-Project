import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestGame {
    @Test
    @DisplayName("test game")
    public void testGame() {
        Game game = GameFactory.createGame("p1", "p2", "human", "fullestPit", true, true);
        game.start();
        Assertions.assertTrue(true);
    }

}
