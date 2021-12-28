
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.*;

class MainTest {
    Main main;

    // runs before each method
    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void introTest(){
        assertEquals(
                "\nYou are in a land full of dragons. In front of you,\n" +
                        "you see two caves. In one cave, the dragon is friendly\n" +
                        "and will share his treasure with you. The other dragon\n" +
                        "is greedy and hungry and will eat you on sight.\n" +
                        "Which cave will you go into? (1 or 2)\n",
                main.intro(),
                "intro has failed"
        );
    }

    @Test
    void goodDragonTest(){
        assertEquals(
                "\nYou approach the cave...\n" +
                "You hear a loud thundering roar follow by a large intimidating silhouette...\n" +
                "You then hear a loud hearty laughter as the silhouette turns into a dragon...\n" +
                "The dragon then asked you if you wanted to be friends and offers a golden grail as a sign of your friendship.",
                main.goodDragon(),
                "goodDragon test failed");
    }

    @Test
    void evilDragonTest(){
        assertEquals(
                "\nYou approach the cave...\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Gobbles you down in one bite!\n",
                main.evilDragon(),
                "evilDragon test failed");
    }

    @Test
    void isLostTest(){
        assertEquals(
                "\nYou made an invalid choice...\n" +
                        "You wander around endlessly in the dungeon...\n" +
                        "You became hungry and start hallucinating...\n" +
                        "As you collapse from exhaustion, your eyes slowly closes seeing a large silhouette laughing at you.",
                main.isLost(),
                "isLost test failed"
        );
    }

    @Test
    void getChoice1Test(){
        assertEquals(main.evilDragon(),  main.getChoice(1),"Choice 1 failed");
    }

    @Test
    void getChoice2Test(){
        assertEquals(main.goodDragon(),  main.getChoice(2),"Choice 2 failed");
    }

    @Test
    void getChoice3Test(){
        assertEquals(main.isLost(),  main.getChoice(3),"Choice 3 failed");
    }

    // run after each method
    @AfterEach
    void tearDown() {
    }


}