import java.util.*;
import java.util.stream.Collectors;

public class Main {
    IOAnswers io;
    private String answer;
    ArrayList<String> toCheck;
    int count;

    public Main(){
        io = new IOAnswers();
        this.answer = getRandomWord();
        this.toCheck = new ArrayList<>( stealthStrArr(answer) );
        this.count = 0;
    }

    public String results(String letter){
        if(toCheck.contains(letter))
            return "you have already guessed that letter. Choose again.";
        if(answer.contains(letter)){
            return "correct";
        }
        this.count++;
        return "incorrect";
    }

    public void revealLetter(String letter){
        answer
    }

    // checking if user wins
    public boolean hasWon(){
        if( !this.toCheck.contains("_")){
            System.out.println("\nYes! The secret word is \"" + this.answer + "\"! You have won!");
            return true;
        }
        return false;
    }

    // creates ____ blanks to start the game
    public List<String> stealthStrArr(String word){
        return Arrays
                .stream(new String[word.length()])
                .map(c -> "_")
                .collect(Collectors.toList());
    }

    // generate hangman art
    public String hangman(int wrongCounter){

        if( wrongCounter > 7 ) return "error";
        return io.art.get(wrongCounter);
    }

    // generate random word
    public String getRandomWord(){
        Random random = new Random();
        return io.words.get(random.nextInt(io.words.size()));
    }

    // user input
    public String userInput(){
        Scanner input = new Scanner(System.in);
        try {
            String guess = input.nextLine().toLowerCase();
            if (guess.length() != 1){
                System.out.println("one letter only please!");
                userInput();
            }
            return guess;

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error: userInput Failed");
            return "?";
        }
    }

    // play again
    public void playAgain(){
        System.out.println("would you like to play again? (y,n)?");
        if( userInput().equals("y")){
            this.answer = getRandomWord();
            this.toCheck = new ArrayList<>( stealthStrArr(answer) );
            this.count = 0;
            gameStart();
        }
    }

    // see the array
    public void seeArray(ArrayList<String> word){
         word.forEach( x -> System.out.print(x + " ") );
    }

    // game begins here
    public void gameStart(){
        System.out.println( hangman(this.count) );
        seeArray(this.toCheck);
        System.out.print("\n\nGuess a letter.\n > ");

    }

    // testing my game
    public static void main(String[] args) {
        Main m = new Main();
        var io = new IOAnswers();

        m.gameStart();
    }



}
