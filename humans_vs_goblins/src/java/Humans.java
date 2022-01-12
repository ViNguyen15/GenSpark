public class Humans {

    private int health, attack, defense;

    public Humans(){
        health = 100;
        attack = 10;
        defense = 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
                "health = " + health +
                ", attack = " + attack +
                '}';
    }
}
