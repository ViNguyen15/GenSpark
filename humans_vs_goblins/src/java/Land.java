import java.util.HashMap;

public class Land {
    private String name;
    private boolean hasTreasure;
    private int n,s,e,w;
    Direction direction;
    private HashMap<String, Integer> navTable;


    public Land(String name, boolean hasTreasure, int north, int south, int east, int west){
        this.name = name;
        this.hasTreasure = hasTreasure;
        this.n = north;
        this.s = south;
        this.e = east;
        this.w = west;

        direction = Direction.North;
        navTable = new HashMap<>();
    }

    public Land(){
        this.name = "nameless";
        this.hasTreasure = false;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getHasTreasure() {
        return hasTreasure;
    }

    public void setHasTreasure(boolean hasTreasure) {
        this.hasTreasure = hasTreasure;
    }

    public HashMap<String, Integer> getNavTable() {
        return navTable;
    }

    public void setNavTable(HashMap<String, Integer> navTable) {
        this.navTable = navTable;
    }

    @Override
    public String toString() {
        return "Land {" +
                "name = '" + name + '\'' +
                ", treasure = " + hasTreasure +
                ", navigation = " + navTable +
                "}\n";
    }
}
