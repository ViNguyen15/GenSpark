import java.util.ArrayList;
import java.util.HashMap;

public class MapLoader {

    ArrayList<Land> map;



    public MapLoader(){
        map = new ArrayList<>();
        map.add( new Land("Great Plateau" , false, 4 , 5, 3 ,6  ) );
        map.add( new Land("Boss Room", true, -1, -1, -1, 4 ) );
        map.add( new Land("The Awakening Chamber", true, 3, -1, -1, -1 ) );
        map.add( new Land("The Brittle Path", false, -1, 2, -1, 0 ) );
        map.add( new Land("Death Mountain", false, -1, 0, 1, -1 ) );
        map.add( new Land("Icy Peak", false, 0, -1, -1, -1 ) );
        map.add( new Land("The Chamber of Secrets", true, -1, -1, 0, -1 ) );

        loadingMap();
    }

    public void loadingMap(){
        for(Land room : map){
            HashMap<String, Integer> nav = new HashMap<>();
            nav.put("north", room.getN());
            nav.put("south", room.getS());
            nav.put("east", room.getE());
            nav.put("west", room.getW());
            room.setNavTable(nav);
        }
    }


    public ArrayList<Land> getAllMaps() {
        return map;
    }
}
