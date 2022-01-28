import java.util.*;
import java.util.stream.IntStream;

public class GameTester {
    public enum compass{north,south,east,west};

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

    // this is what allows us to be in a room
    public void setCurrentRoom(Land currentRoom) {
        this.currentRoom = currentRoom;
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
        MainApplication mainA = new MainApplication();

        getCurrentRoomName();
        System.out.println(player);
        getGoblinRoomName();
        System.out.println(goblin);

        battleCondition();

        System.out.print("\nWhat do you do?\n> ");
        playerDecision( userCommand() );


        goblinDecision();

        userInterface();
    }

    // a condition for battle
    public void battleCondition(){
        if( currentRoom.getName().equals( goblinRoom.getName() ) )
            battle();
    }

    // what happends during battle
    public void battle(){
        System.out.println("\nbattle happened!");
        goblin.setHealth(goblin.getHealth() - player.getAttack());
        player.setHealth(player.getHealth() - goblin.getAttack());
        System.out.println(player + "\n" + goblin);
    }

    // return room name but also print where it is
    public String getCurrentRoomName(){
        System.out.println("\n------------------\nYou are in " + currentRoom.getName() );
        return currentRoom.getName();
    }

    // return room name for goblin and print where it is at
    public String getGoblinRoomName(){
        System.out.println("\nGoblin is in " + goblinRoom.getName() );
        return goblinRoom.getName();
    }

    // this method represent all action after decision has been made
    public void playerDecision(String decision){
        decision = playerDecisionTranslator(decision);
        List compassMoves = Arrays.asList( new String[]{"north","east","south","west"} );

        try {
            if(compassMoves.contains(decision)) {
                setCurrentRoom( map.get( toMove( decision ) ) );
            }

        }catch (NullPointerException e){
            System.err.println("Error: failure playerDecision NullPointer");
            return;
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error: failure playerDecision Array Index Out of Bounds");
            return;
        }
    }

    // this method is used to decode directions
    public int toMove(String direction ){
        if( currentRoom.getNavTable().get( direction ) == -1 ) {
            System.out.println("dead end try another route");
            userInterface();
        }
        return currentRoom.getNavTable().get( direction );
    }



    // whatever user type will be translated
    public String playerDecisionTranslator(String decision){
        switch(decision.toLowerCase()){
            // north
            case "north" :
            case "up" :
            case "forward" :
            case "n" :
                return "north";

            //south
            case "south" :
            case "down" :
            case "back" :
            case "backwards" :
            case "s" :
                return "south";

            //east
            case "east" :
            case "right" :
            case "e" :
                return "east";

            //west
            case "west" :
            case "left" :
            case "w" :
                return "west";

            //combat
            case "fight" :
            case "battle" :
            case "attack" :
            case "kill" :
            case "to battle" :
                return "battle";

            //other
//            case "" :
//            case "" :
//            case "" :
//            case "" :
//                return "";
        }

        return decision;
    }

    // main
    public static void main(String[] args) {
        new GameTester().userInterface();
    }


    /**vvvvvvvvvvvvvvvvvvvvvv below is code exclusive for the gui vvvvvvvvvvvvvvvvvvvvvvvvvv**/

    // this method represent all action after decision has been made
    public void specialMove(String decision){
        List compassMoves = Arrays.asList( new String[]{"north","east","south","west"} );

        try {
            if(compassMoves.contains(decision)) {
                setCurrentRoom( map.get( toSpecialMove( decision ) ) );
                System.out.println("You are in " + currentRoom.getName());
            }

        }catch (NullPointerException e){
            System.err.println("Error: failure playerDecision NullPointer");
            return;
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error: failure playerDecision Array Index Out of Bounds");
            return;
        }
    }

    // this method is used to decode directions
    public int toSpecialMove(String direction ){
        if( currentRoom.getNavTable().get( direction ) == -1 ) {
            System.out.println("dead end try another route");
            return 0;
        }
        return currentRoom.getNavTable().get( direction );
    }

}
