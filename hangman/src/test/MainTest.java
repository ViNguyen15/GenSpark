import org.junit.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void setUp(){
        main = new Main();
        main.setCounter(3);
        String wordTest = "dog";
        main.setAnswer(wordTest);
        main.toCheck = (main.stealthStrArr(wordTest));
    }

    @Test
    void resultsTest(){
        assertEquals("correct",main.results("o"),"resultsTest has failed");
        assertEquals("incorrect",main.results("p"),"resultsTest has failed");
    }

    @AfterEach
    void tearDown(){

    }
}