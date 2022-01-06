import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private int answer, playerChoice;
    private String toContinue;
    private String playerName;

    public Main(){

    }

    //getter setter for player name
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String name){
        this.playerName = name;
    }

    //getter setter for toContinue option
    public String getToContinue(){
        return toContinue;
    }
    public void setToContinue(String toContinue) {
        this.toContinue = toContinue;
    }


    //getter setter for player choice
    public int getPlayerChoice(){
        return playerChoice;
    }
    public void setPlayerChoice(int playerChoice) {
        this.playerChoice = playerChoice;
    }

    //getter setter for answer
    public int getAnswer(){
        return answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }

    // intro of the game
    public void intro(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
        try {
            setPlayerName( input.nextLine() );
        }catch (Exception e){
            System.out.println("Player name error... HOW!?\nWell your name is now John Doe...\n");
            setPlayerName("John Doe");
        }
    }

    //this is to generate a number between 1 and 20
    private void answerGenerate(){
        System.out.println("Well, " + getPlayerName() + " I am thinking of a number between 1 and 20");
        Random random = new Random();
        setAnswer(random.nextInt(20)+1);
    }

    //the actual game is here
    public void guessingGame(){
        int count = 0;

        while(count<6){
            System.out.println("take a guess");

            setPlayerChoice( playerDecision() );
            if (getPlayerChoice() > getAnswer() )
                System.out.println("Your guess is too high.");
            if (getPlayerChoice() < getAnswer() )
                System.out.println("Your guess is too low.");
            if (getPlayerChoice() == getAnswer() ) {
                System.out.println("Good job, " + getPlayerName() + " You guessed my number in " + (count + 1) + " guesses!");
                return;
            }
            count++;
        }
        if(count == 6)
            System.out.println("You tried too many times, the answer is " + getAnswer() + "\n");
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
        setToContinue("y");

        intro();
        while(getToContinue().equals("y")) {
            answerGenerate();
            guessingGame();
            System.out.println("Would you like to play again? (y or n)");
            try{
                setToContinue( input.nextLine().toLowerCase() );
            }catch (Exception e) {
                System.out.println("What did you enter!?");
                setToContinue("n");
            }
        }
    }

    public static void main(String[] args) {
        new Main().runningFullGame();
    }

}