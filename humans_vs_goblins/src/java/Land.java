public class Land {
    private String name;
    private boolean treasure;

    public Land(String name, boolean treasure){
        this.name = name;
        this.treasure = treasure;
    }

    public Land(){
        this.name = "nameless";
        this.treasure = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTreasure() {
        return treasure;
    }

    public void setTreasure(boolean treasure) {
        this.treasure = treasure;
    }

    @Override
    public String toString() {
        return "Land {" +
                "name='" + name + '\'' +
                ", treasure=" + treasure +
                '}';
    }
}
