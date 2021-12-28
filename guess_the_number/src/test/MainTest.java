import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
        main.setToContinue("y");
        main.setAnswer(10);
        main.setPlayerName("John");
        main.setPlayerChoice(15);
    }

    @Test
    void getPlayerName() {
        assertEquals("John", main.getPlayerName(), "Player Name has failed");
    }

    @Test
    void getToContinue() {
        assertEquals("y", main.getToContinue(), "toContinue has failed");
    }

    @Test
    void getPlayerChoice() {
        assertEquals(15, main.getPlayerChoice(), "playerChoice has failed");
    }

    @Test
    void getAnswer() {
        assertEquals(10, main.getAnswer(), "Answer has failed");
    }

    @AfterEach
    void tearDown() {
    }
}
