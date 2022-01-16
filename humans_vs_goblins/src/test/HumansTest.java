import static org.junit.jupiter.api.Assertions.*;

class HumansTest {
    Humans hTest;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hTest = new Humans();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getHealth() {

        assertEquals(100, hTest.getHealth(),"Error: getHealth failed");

    }

    @org.junit.jupiter.api.Test
    void setHealth() {
        hTest.setHealth(70);
        assertEquals(70, hTest.getHealth(),"Error: setHealth failed");
    }

    @org.junit.jupiter.api.Test
    void getAttack() {
        assertEquals(10, hTest.getAttack(),"Error: getAttack failed");
    }

    @org.junit.jupiter.api.Test
    void setAttack() {
        hTest.setAttack(30);
        assertEquals(30, hTest.getAttack(),"Error: setAttack failed");
    }

    @org.junit.jupiter.api.Test
    void getDefense() {
        assertEquals(0, hTest.getDefense(), "Error: getDefense failed");
    }

    @org.junit.jupiter.api.Test
    void setDefense() {
        hTest.setDefense(30);
        assertEquals(30, hTest.getDefense(), "Error: setDefense failed");
    }
}