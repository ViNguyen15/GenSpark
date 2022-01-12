import java.util.*;

public class GameTester {
    Land currentRoom;
    Land goblinRoom;
    ArrayList<Land> map;
    Humans player;
    Goblins goblin;

    // constructor
    public GameTester(){
        map = new MapLoader().getAllMaps();
        currentRoom = map.get(2); // 2 is The awakening chamber for starting point
        goblinRoom = map.get(1); // 1 is The boss room for enemies to spawn
        player = new Humans();
        goblin = new Goblins();
    }

    // main
    public static void main(String[] args) {
        new GameTester().userInterface();
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

    // this is how the goblin traverse through the map
    public void goblinDecision(){
        Random random = new Random();
        ArrayList<Integer> possibleRoute = new ArrayList<>();

        if(goblinRoom.getN()!=-1)
            possibleRoute.add(goblinRoom.getN());
        if(goblinRoom.getS()!=-1)
            possibleRoute.add(goblinRoom.getS());
        if(goblinRoom.getE()!=-1)
            possibleRoute.add(goblinRoom.getE());
        if(goblinRoom.getW()!=-1)
            possibleRoute.add(goblinRoom.getW());

        goblinRoom = map.get( possibleRoute.get( random.nextInt( possibleRoute.size() ) ) );
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
    public void userInterface() {
        System.out.println("\n------------------\nYou are in " + currentRoom.getName() );
        System.out.println(player);
        System.out.println("\nGoblin is in " + goblinRoom.getName() );
        System.out.println(goblin);

        if(currentRoom.getName().equals(goblinRoom.getName())) {
            System.out.println("\nbattle happened!");
            goblin.setHealth(goblin.getHealth()- player.getAttack());
            player.setHealth(player.getHealth() - goblin.getAttack());
            System.out.println(player + "\n" + goblin);
        }

        System.out.print("\nWhat do you do?\n> ");

        String move = userCommand();
        playerDecision(move);
    }

    // this method represent all action after decision has been made
    public void playerDecision(String decision){
        try {
            setCurrentRoom( map.get( toMove( decision, currentRoom.getNavTable() ) ) );
            goblinDecision();
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
