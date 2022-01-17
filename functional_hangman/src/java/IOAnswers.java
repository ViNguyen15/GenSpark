import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOAnswers {
    static List<String> answers;


//    static {
//        try {
//            answers = Files.readAllLines( Paths.get("resources/words_database") )
//                    .stream()
//                    .map( a -> Arrays.asList(Arrays.stream(Arrays.stream(a.split(","))
//                                    .map(c -> c  (char)Integer.parseInt(c) )
//                            )
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) throws IOException {
        System.out.println(
            Files.readAllLines( Paths.get("src/resources/words_database.txt") )
        );

        Files.readAllLines( Paths.get("src/resources/words_database.txt"))
                .stream()
                .map( e -> {

                    Arrays.stream(e.split(",")).collect(Collectors.toList());



                    return e;
                } )
                ;
    }
}
