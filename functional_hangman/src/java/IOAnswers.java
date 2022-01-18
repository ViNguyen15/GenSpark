import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOAnswers {
    static List<String> words;
    static List<String> art;

    static {
        try {
            words = Files.readAllLines( Paths.get("src/resources/words_database.txt"))
                    .stream()
                    .map( e -> Arrays.stream( e.split(",") )
                            .map( n -> (char)Integer.parseInt(n) )
                            .map(String::valueOf)
                            .collect( Collectors.joining() ) )
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            art = new ArrayList<String>() {
                {
                    add(Files.lines(Paths.get("src/resources/hangman/hangman0.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                    add(Files.lines(Paths.get("src/resources/hangman/hangman1.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                    add(Files.lines(Paths.get("src/resources/hangman/hangman2.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                    add(Files.lines(Paths.get("src/resources/hangman/hangman3.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                    add(Files.lines(Paths.get("src/resources/hangman/hangman4.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                    add(Files.lines(Paths.get("src/resources/hangman/hangman5.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                    add(Files.lines(Paths.get("src/resources/hangman/hangman6.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                    add(Files.lines(Paths.get("src/resources/hangman/hangman7.txt"))
                            .collect(Collectors.joining(System.lineSeparator())));
                }
            };
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                art.get(7)
        );

    }
}
