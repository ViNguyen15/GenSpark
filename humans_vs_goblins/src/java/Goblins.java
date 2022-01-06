public class Goblins {
    private int health, attack;

    public Goblins(){
        health = 10;
        attack = 10;
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

    @Override
    public String toString() {
        return "Goblins {" +
                "health=" + health +
                ", attack=" + attack +
                '}';
    }
}
