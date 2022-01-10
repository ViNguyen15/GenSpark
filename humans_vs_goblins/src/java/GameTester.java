import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class GameTester {

    public static void main(String[] args) {
        ArrayList<Land> map = new ArrayList<Land>();
        Goblins g = new Goblins();
        Humans h = new Humans();


        map.add( new Land("Great Plateau" , false, 1 , -1, -1 , -1 ) );
        map.add( new Land("Boss Room", true, -1, 0, -1, -1 ) );


        for(Land x : map){
            HashMap<String, Integer> nav = new HashMap<>();
            nav.put("north", x.getN());
            nav.put("south", x.getS());
            nav.put("east", x.getE());
            nav.put("west", x.getW());
            x.setNavTable(nav);
        }



        System.out.println(map.get(0).getNavTable());
        System.out.println(map.get(0));
        System.out.println(map.get(1));
        //System.out.println(g + "\n" + h + "\n" + map);


    }
}
