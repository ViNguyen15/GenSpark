import java.util.ArrayList;
import java.util.HashMap;

public class GameTester {

    public static void main(String[] args) {
        ArrayList<Land> map = new ArrayList<Land>();
        Goblins g = new Goblins();
        Humans h = new Humans();
        HashMap<String, Integer> nav = new HashMap<>();

        map.add( new Land("Great Plateau" , false, 1 , -1, -1 , -1 ) );
        map.add( new Land("Boss Room", true, -1, 0, -1, -1 ) );

        nav.put("north", 0);
        nav.put("south", 0);
        nav.put("east", 0);
        nav.put("west", 0);


        System.out.println(g + "\n" + h + "\n" + map);

    }
}
