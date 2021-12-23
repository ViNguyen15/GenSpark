import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Random random = new Random();

        int playerChoice;
        int answer;

        String toContinue = "y";

        System.out.println("Hello! What is your name?");
        String name = input1.nextLine();

        while(toContinue.equals("y")) {
            System.out.println("Well, " + name + " I am thinking of a number between 1 and 20");
            answer = random.nextInt(20) + 1;
            //System.out.println(answer);



            System.out.println("Would you like to play again? (y or n)");
            toContinue = input2.next();
        }

    }
    public static void guessingGame(int answer){
        Scanner input1 = new Scanner(System.in);

        int count = 0;
        while (count < 6) {
            System.out.println("Take a guess");

            try {
                playerChoice = input1.nextInt();
                if (playerChoice > answer)
                    System.out.println("Your guess is too high.");
                if (playerChoice < answer)
                    System.out.println("Your guess is too low.");
                if (playerChoice == answer) {
                    System.out.println("Good job, " + name + " You guessed my number in " + (count + 1) + " guesses!");
                    break;
                }
                count++;

            } catch (InputMismatchException e) {
                System.out.println("Error: Not a number!");
                playerChoice = 0;
                count = 6;
            }

        }

        if(count == 6)
            System.out.println("You tried too many times, the answer is " + answer);
    }
}
