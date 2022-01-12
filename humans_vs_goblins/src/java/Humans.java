public class Humans {

    private int heatlh, attack, defense;

    public Humans(){
        heatlh = 10;
        attack = 10;
        defense = 0;
    }

    public int getHeatlh() {
        return heatlh;
    }

    public void setHeatlh(int heatlh) {
        this.heatlh = heatlh;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Humans {" +
                "heatlh = " + heatlh +
                ", attack = " + attack +
                '}';
    }
}
