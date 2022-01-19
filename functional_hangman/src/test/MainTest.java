import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main m;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        m = new Main();
        m.answer = "";
        m.toCheck = new ArrayList<>( m.stealthStrArr( m.answer ) );
        m.count = 0;
    }

    @Test
    public void results(){

    }
}