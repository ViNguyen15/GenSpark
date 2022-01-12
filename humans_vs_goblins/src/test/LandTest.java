import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class LandTest {
    Land land;

    @BeforeEach
    void setup(){
        land = new Land("Testing Land", false, 1,2,3,4);
    }

    @Test
    void nameTest(){
        assertEquals("Testing Land", land.getName(), "getName failed");
        land.setName("TestLand");
        assertEquals("TestLand", land.getName(), "setName failed");
    }


    @Test
    void getCompassTest(){
        assertEquals(1,land.getN(),"getN failed");
        assertEquals(2,land.getS(),"getS failed");
        assertEquals(3,land.getE(),"getE failed");
        assertEquals(4,land.getW(),"getW failed");
    }

    @Test
    void setCompassTest(){
        land.setN(0);
        land.setS(0);
        land.setE(0);
        land.setW(0);
        assertEquals(0,land.getN(),"setN failed");
        assertEquals(0,land.getS(),"setS failed");
        assertEquals(0,land.getE(),"setE failed");
        assertEquals(0,land.getW(),"setW failed");
    }

    @Test
    void treasureTest(){
        assertEquals(false,land.getHasTreasure(), "getHasTreasure failed");
        land.setHasTreasure(true);
        assertEquals(true,land.getHasTreasure(),"setHasTreasure failed");
    }

    @Test
    void navTableTest(){
        assertEquals(true, land.getNavTable().isEmpty(), "getNavTable failed");
        HashMap<String, Integer> mapTest = new HashMap<>();
        mapTest.put("north", 10);
        land.setNavTable(mapTest);
        assertEquals(10,land.getNavTable().get("north"),"setNavTable failed");
    }

    @AfterEach
    void tearDown(){

    }

}