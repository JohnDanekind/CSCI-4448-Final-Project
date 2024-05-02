import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestGameFactory {


    @Test
    @DisplayName("test invalid strategy name in GameFactory")
    public void testGame() {

        boolean passed = false;

        try {
            Game game = GameFactory.createGame("test1", "test2", "WRONG", "WRONG", false, false);
        }
        catch (IllegalArgumentException e) {
            passed = true;
        }

        Assertions.assertTrue(passed);
    }
}