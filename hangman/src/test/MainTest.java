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
        main.revealLetter("g");
    }

    @Test
    void resultsTest(){
        assertEquals("correct",main.results("o"),"resultsTest correct has failed");
        assertEquals("incorrect",main.results("p"),"resultsTest incorrect has failed");
        assertEquals("you have already guessed that letter. Choose again.",main.results("g"),"resultsTest already guessed has failed");
    }

    @Test
    void stealthStrArrTest(){
        String[] expected = {"_","_","_","_"};
        String wordTest = "halo";
        assertArrayEquals(expected, main.stealthStrArr(wordTest), "stealthStrArr method has failed");
    }

    @Test
    void checkGameResultTest(){
        assertEquals(false, main.checkGameResult(), "checkGameResult failed");
    }

    @Test
    void getAnswerTest(){
        main.setAnswer("halo");
        assertEquals("halo", main.getAnswer(), "getAnswer failed");
    }

    @Test
    void getCounterTest(){
        main.setCounter(6);
        assertEquals(6, main.getCounter(), "getCounter failed");
    }

    @Test
    public void revealLetterTest(){
        main.revealLetter("d");
        main.revealLetter("o");
        main.revealLetter("g");
        assertEquals(true, main.checkGameResult(), "revealLetterTest failed");
    }

    @AfterEach
    void tearDown(){

    }
}