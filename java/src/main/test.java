import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class test {
    @Test
    public void createRockQuestiontest(){
        Game g = new Game();
        assertEquals("Rock Question 1", g.createRockQuestion(1));
    }

}
