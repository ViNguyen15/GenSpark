import java.util.*;
import java.util.stream.Stream;

public class GameTester {

    Land currentRoom;
    Land goblinRoom;

    ArrayList<Land> map;
    Humans human;
    Goblins goblin;

    public GameTester(){
        map = new MapLoader().getAllMaps();
        currentRoom = map.get(2); // 2 is The awakening chamber for starting point
        goblinRoom = map.get(1);
    }

    public static void main(String[] args) {
        GameTester gt = new GameTester();

        gt.userInterface();
    }

    // this is what allows us to be in a room
    public void setCurrentRoom(Land currentRoom) {
        this.currentRoom = currentRoom;
    }

    // this method is used to decode directions
    public int toMove(String direction, HashMap<String, Integer> room){
        if(room.get(direction)==-1) {
            System.out.println("dead end try another route");
            userInterface();
        }
        return room.get(direction);
    }

    public void goblinDecision(){

    }

    // built for requesting user command
    public String userCommand(){
        Scanner input = new Scanner(System.in);
        String command;
        try{
            command = input.nextLine();
            return command.toLowerCase();

        } catch (Exception e){
            return "Error: method userCommand failed";
        }
    }

    // this is default hub which is display information
    public void userInterface(){
        System.out.println(currentRoom.getName());
        String move = userCommand();
        playerDecision(move);
    }

    // this method represent all action after decision has been made
    public void playerDecision(String decision){
        try {
            setCurrentRoom( map.get( toMove( decision, currentRoom.getNavTable() ) ) );
            userInterface();
        }catch (NullPointerException e){
            System.err.println("Error: failure playerDecision NullPointer");
            return;
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error: failure playerDecision Array Index Out of Bounds");
            return;
        }
    }

}
