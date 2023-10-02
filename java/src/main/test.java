import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void didPlayerWintest(){ //if player wins then the test is set to true
        Player g = new Player("Test");
        g.setPurse(6);
        assertTrue("Player won", g.didPlayerWin());
        }
    }
