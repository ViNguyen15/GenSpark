import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String toContinue = "y";

        System.out.println("Hello! What is your name?");
        String name = input.nextLine();

        while(toContinue.equals("y")) {
            System.out.println("Well, " + name + " I am thinking of a number between 1 and 20");
            int answer = random.nextInt(20) + 1;
            System.out.println(answer);

            int count = 0;
            while (count < 6) {
                System.out.println("Take a guess");
                int playerChoice = input.nextInt();
                if (playerChoice > answer)
                    System.out.println("Your guess is too high.");
                if (playerChoice < answer)
                    System.out.println("Your guess is too low.");
                if (playerChoice == answer) {
                    System.out.println("Good job, " + name + " You guessed my number in " + (count + 1) + " guesses!");
                    break;
                }
                count++;
            }

            if(count == 6)
                System.out.println("You tried too many times, the answer is " + answer);

            System.out.println("Would you like to play again? (y or n)");
            toContinue = input.next();
        }

    }

}
