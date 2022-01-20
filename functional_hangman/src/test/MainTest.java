import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main m;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        m = new Main();
        m.answer = "test";
        m.toCheck = new ArrayList<>( m.stealthStrArr( m.answer ) );
        m.count = 2;
    }

    @Test
    public void resultsTest(){
        assertEquals("correct",m.results("t"),"Error, results failed");
    }

    @Test
    public void revealLetterTest(){
        m.revealLetter("t");
        assertEquals(new ArrayList<String>(){{
            add("t");
            add("_");
            add("_");
            add("t");
        }}, m.toCheck, "Error, revealLetter failed"
        );
    }

    @Test
    public void hasWonTest(){
        m.revealLetter("t");
        m.revealLetter("e");
        m.revealLetter("s");
        assertEquals(true, m.hasWon(), "Error, hasWon failed");

    }

    @Test
    public void hasLostTest(){
        m.count = 7;
        assertEquals(true, m.hasLost(), "Error, hasLost failed");
    }

    @Test
    public void stealthStrArrTest(){
        assertEquals(
                Arrays.asList(new String[]{"_","_","_","_","_","_",})
                , m.stealthStrArr("random")
                , "Error stealthStrArr failed"
        );

    }

}