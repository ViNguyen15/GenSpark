
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public void startGame(){

        System.out.println(intro());

        Scanner input = new Scanner(System.in);
        try{
            System.out.println( getChoice( input.nextInt() ) );
        }catch (InputMismatchException e){
            System.out.println("Error: Not a number");
        }
    }

    public String getChoice(int choice){
        if (choice == 1)
            return evilDragon();
        if (choice == 2)
            return goodDragon();
        return isLost();
    }

    public String intro(){
        return ("\nYou are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)\n");
    }

    public String goodDragon(){
        return ("\nYou approach the cave...\n" +
                "You hear a loud thundering roar follow by a large intimidating silhouette...\n" +
                "You then hear a loud hearty laughter as the silhouette turns into a dragon...\n" +
                "The dragon then asked you if you wanted to be friends and offers a golden grail as a sign of your friendship.");
    }

    public String evilDragon(){
        return ("\nYou approach the cave...\n" +
                "It is dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "Gobbles you down in one bite!\n");
    }

    public String isLost(){
        return ("\nYou made an invalid choice...\n" +
                "You wander around endlessly in the dungeon...\n" +
                "You became hungry and start hallucinating...\n" +
                "As you collapse from exhaustion, your eyes slowly closes seeing a large silhouette laughing at you.");
    }

    public static void main(String[] args) {
        new Main().startGame();
    }
}