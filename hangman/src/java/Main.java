public class Main {
    String answer;
    String[] hiddenAnswer;
    String[] toCheck;

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.view(5));
        m.seeArray(m.stealthStrArr("dinosaur"));
    }

    public String[] stealthStrArr(String word){
        String[] hidden = new String[word.length()];
        for(int i = 0; i < hidden.length; i++)
            hidden[i] = "_";
        return hidden;
    }

    public String view(int wrongCounter){
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
            default:
        }
        return "error";
    }

    public void seeArray(String[] wordList){
        for(String word : wordList)
            System.out.print(word + " ");
    }

}
