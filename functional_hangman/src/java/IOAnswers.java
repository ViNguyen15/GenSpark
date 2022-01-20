import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IOAnswers {
    static List<String> words;
    static List<String> art;

    // grab a list of all the words from the word database text file
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

    // grab arts for hangman from hangman_full_art
    static {
        try {
            art = IntStream.range(0, Files.readAllLines( Paths.get("src/resources/hangman/hangman_full_art.txt") ).size()/5 )
            .mapToObj(x -> {
                try {
                    return Files.readAllLines( Paths.get("src/resources/hangman/hangman_full_art.txt") )
                            .subList( (x*5), (x+1)*5 );
                } catch (IOException e) {
                    return new ArrayList<String>(){{ add("error"); }};
                }
            })
                    .collect(Collectors.toList())
                    .stream()
                    .map( s -> s
                            .stream()
                            .collect( Collectors.joining( System.lineSeparator() ) ) )
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // grab arts for hangman //legacy code
//    static {
//        try {
//            art = new ArrayList<String>() {
//                {
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman0.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman1.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman2.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman3.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman4.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman5.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman6.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                    add(Files.lines(Paths.get("src/resources/hangman/hangman7.txt"))
//                            .collect(Collectors.joining(System.lineSeparator())));
//                }
//            };
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws IOException {
//        System.out.println(
//                maxProfit(2,Arrays.asList(7,3,1,5,1,-3))
//        );

        //IntStream.range(0,Files.lines(Paths.get("src/resources/hangman/hangman0.txt") ) )

        //IntStream.range(0,11).map(x -> x * 10).forEach(n -> System.out.print(n + " "));

    }
}
