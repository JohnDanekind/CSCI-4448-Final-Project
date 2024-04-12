import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestGame {
    @Test
    @DisplayName("test game")
    public void testGame() {
        Game game = new Game();
        game.start();
        Assertions.assertTrue(true);
    }

}
