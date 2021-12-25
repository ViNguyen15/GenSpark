import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private int answer, playerChoice, count;
    private String toContinue;
    private String playerName;

    public Main(){
        runningFullGame();
    }

    // intro of the game
    public void intro(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        try {
            playerName = input.nextLine();
        }catch (Exception e){
            System.out.println("Player name error... HOW!?\nWell your name is now John Doe...\n");
            playerName = "John Doe";
        }
    }

    //this is to generate a number between 1 and 20
    private void answerGenerate(){
        System.out.println("Well, " + playerName + " I am thinking of a number between 1 and 20");
        Random random = new Random();
        this.answer = random.nextInt(20)+1;
    }

    //the actual game is here
    public void guessingGame(){
        count = 0;

        while(count<6){
            System.out.println("take a guess");

            playerChoice = playerDecision();
            if (playerChoice > answer)
                System.out.println("Your guess is too high.");
            if (playerChoice < answer)
                System.out.println("Your guess is too low.");
            if (playerChoice == answer) {
                System.out.println("Good job, " + playerName + " You guessed my number in " + (count + 1) + " guesses!");
                return;
            }
            count++;
        }
        if(count == 6)
            System.out.println("You tried too many times, the answer is " + answer + "\n");
    }

    // made for try catch controls
    public int playerDecision(){
        Scanner input = new Scanner(System.in);
        try {
            return input.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Error: Not a number!");
            return 22;
        }
    }

    public void runningFullGame(){
        Scanner input = new Scanner(System.in);
        toContinue = "y";

        intro();
        while(toContinue=="y") {
            answerGenerate();
            guessingGame();
            System.out.println("Would you like to play again? (y or n)");
            try{
                toContinue = input.nextLine().toLowerCase();
            }catch (Exception e) {
                System.out.println("What did you enter!?");
                toContinue = "n";
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}