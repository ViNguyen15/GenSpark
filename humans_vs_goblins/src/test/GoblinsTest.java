import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinsTest {
    Goblins jG;

    @BeforeEach
    void setUp() {
        jG = new Goblins();
    }

    @Test
    void getHealth() {
        assertEquals(100, jG.getHealth(), "Error: getHealth failed");
    }

    @Test
    void setHealth() {
        jG.setHealth(80);
        assertEquals(80,jG.getHealth(),"Error: setHealth failed");
    }

    @Test
    void getAttack() {
        assertEquals(10, jG.getAttack(), "Error: getAttack failed");
    }

    @Test
    void setAttack() {
        jG.setAttack(20);
        assertEquals(20,jG.getAttack(), "Error: setAttack failed");
    }
}