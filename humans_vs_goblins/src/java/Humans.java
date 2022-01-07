public class Humans {

    private int heatlh, attack;

    public Humans(){
        heatlh = 10;
        attack = 10;
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

    @Override
    public String toString() {
        return "Humans {" +
                "heatlh = " + heatlh +
                ", attack = " + attack +
                '}';
    }
}
