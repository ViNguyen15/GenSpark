import java.util.Random;
import java.util.Scanner;

public class Main {
    private String answer;
    String[] toCheck;
    int counter;

    public Main(){
        //gameStart();
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    // randomly choose a word from the database
    public String getRandomWord(){
        String[] wordDatabase = {"apple", "alphabet", "fox", "cat", "shirakami", "pokemon", "zelda", "dog"};
        Random random = new Random();
        return wordDatabase[random.nextInt(wordDatabase.length)];
    }

    // array doesnt have a .contains so I made one
    public boolean contains(String[] list, String item){
        for(String element : list)
            if(element.equals(item))
                return true;
        return false;
    }

    // guessed letter comes in results comes out
    public String results(String letter){
        if(contains(toCheck, letter))
            return "you have already guessed that letter. Choose again.";
        if(getAnswer().contains(letter)) {
            revealLetter(letter);
            return "correct";
        }
        setCounter(getCounter()+1);
        return "incorrect";
    }

    // if the letter is guessed correctly it shall be revealed
    public void revealLetter(String letter){
        for(int i = 0; i < getAnswer().length(); i++){
            if(getAnswer().charAt(i)==letter.charAt(0))
                toCheck[i] = letter;
        }
    }

    // this creates the ____ blanks to start the game
    public String[] stealthStrArr(String word){
        String[] hidden = new String[word.length()];
        for(int i = 0; i < hidden.length; i++)
            hidden[i] = "_";
        return hidden;
    }

    // this is where the hangman is drawn
    public String hangman(int wrongCounter){
        switch(wrongCounter) {
            case 0:
                return (" +---+\n" +
                        "     |\n" +
                        "     |\n" +
                        "     |\n" +
                        "    ===");
            case 1:
                return (" +---+\n" +
                        " O   |\n" +
                        "     |\n" +
                        "     |\n" +
                        "    ===");
            case 2:
                return (" +---+\n" +
                        " O   |\n" +
                        " |   |\n" +
                        "     |\n" +
                        "    ===");
            case 3:
                return (" +---+\n" +
                        " O   |\n" +
                        " |   |\n" +
                        " |   |\n" +
                        "    ===");
            case 4:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|   |\n" +
                        " |   |\n" +
                        "    ===");
            case 5:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|-  |\n" +
                        " |   |\n" +
                        "    ===");
            case 6:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|-  |\n" +
                        " |   |\n" +
                        "/   ===");
            case 7:
                return (" +---+\n" +
                        " O   |\n" +
                        "-|-  |\n" +
                        " |   |\n" +
                        "/ \\ ===");
        }
        return "error";
    }

    // this was made to see the array
    public void seeArray(String[] wordList){
        for(String word : wordList)
            System.out.print(word + " ");
    }

    // checks to see if any of the blanks is still there
    public boolean checkGameResult(){
        if(contains(toCheck, "_"))
            return false;
        return true;
    }

    //where the guess takes place
    public String theGuess(){
        Scanner input = new Scanner(System.in);
        System.out.print("\n\nGuess a letter.\n > ");

        try{
            String guess = input.nextLine().toLowerCase();
            if(guess.length()>1) {
                System.out.println("one letter at a time please!");
                return theGuess();
            }
            if(guess.isEmpty())
                return "+";
            return guess;
        }catch(Exception e){
            System.out.println(e + " Error in theGuess method");
            return theGuess();
        }
    }

    // to ask if they want to play again or not
    public void playAgain(){
        Scanner input = new Scanner(System.in);

         try{
             String answer = input.nextLine();
             if(answer.equals("yes"))
                 gameStart();
             else if(answer.equals("no"))
                 return;
             else{
                 System.out.println("is that a yes or a no?");
                 playAgain();
             }
         }catch(Exception e){
             System.err.println(e);
         }
    }

    // the game starts here
    public void gameStart(){
        setCounter(0);
        boolean gameOver = false;
        String word = getRandomWord();
        setAnswer(word);
        toCheck = (stealthStrArr(word));

        while(!gameOver) {
            System.out.println("****************************");
            System.out.println(hangman(getCounter()));
            seeArray(toCheck);

            String guess = theGuess();
            System.out.println(results(guess));

            // if guess too many times game ends
            if(getCounter()==7){
                System.out.println("\nOh No you lost!");
                gameOver = true;
            }

            // if all letters are guessed correctly game ends
            if(checkGameResult()) {
                System.out.println("\nYes! The secret word is \"" + getAnswer() + "\"! You have won!");
                gameOver = true;
            }
        }
        System.out.println("\n********************************");
        System.out.println("Do you want to play again? (yes or no)");
        playAgain();
    }

    // main
    public static void main(String[] args) {
        new Main().gameStart();
    }
}
