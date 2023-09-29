import org.junit.*;
import main.Game;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SomeTest {

    @Test
    public void true_is_true() throws Exception {
        assertTrue("Hello");
    }
    public String createRockQuestionTest(int index) throws Exception{
        Game g = new Game();
		assertEquals("Rock Question 1", g.createRockQuestion(1));
	}
}
