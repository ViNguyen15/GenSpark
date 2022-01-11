import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameTester {

    Land currentRoom;
    static ArrayList<Land> map;

    public static void main(String[] args) {
        GameTester gt = new GameTester();
        map = new ArrayList<Land>();
        Goblins g = new Goblins();
        Humans h = new Humans();


        map.add( new Land("Great Plateau" , false, 4 , 5, 3 ,6  ) );
        map.add( new Land("Boss Room", true, -1, -1, 4, -1 ) );
        map.add( new Land("The Awakening Chamber", true, 3, -1, -1, -1 ) );
        map.add( new Land("The Brittle Path", false, -1, 2, -1, 0 ) );
        map.add( new Land("Death Mountain", false, -1, 0, 1, -1 ) );
        map.add( new Land("Icy Peak", false, 0, -1, -1, -1 ) );
        map.add( new Land("The Chamber of Secrets", true, -1, -1, 6, -1 ) );

        for(Land x : map){
            HashMap<String, Integer> nav = new HashMap<>();
            nav.put("north", x.getN());
            nav.put("south", x.getS());
            nav.put("east", x.getE());
            nav.put("west", x.getW());
            x.setNavTable(nav);
        }
        //System.out.println(g + "\n" + h + "\n" + map);

        gt.currentRoom = map.get(2);
        gt.userInterface();

    }

    public void setCurrentRoom(Land currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int toMove(String direction, HashMap<String, Integer> room){
        if(room.get(direction)==-1) {
            System.out.println("dead end try another route");
            return 0;
        }
        return room.get(direction);
    }

    public void userInterface(){
        Scanner input = new Scanner(System.in);
        System.out.println(currentRoom.getName());
        String move = input.nextLine();
        playerDecision(move);
    }

    public void playerDecision(String decision){
        setCurrentRoom( map.get( toMove( decision, currentRoom.getNavTable() ) ) );
        userInterface();
    }

}
