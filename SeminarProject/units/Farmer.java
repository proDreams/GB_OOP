package units;

import java.util.ArrayList;

public class Farmer extends BaseHero {
    protected boolean supply;

    public Farmer(String name, String role, int attack, int defence, int[] damage, int health, int speed) {
        super(name, role, attack, defence, damage, health, speed);
    }

    public Farmer(String name){
        super(name, "Farmer", 1, 1, new int[] {1, 1}, 1, 3);
        this.supply = true;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        supply = true;
    }
    @Override
    public String toString() {
        return super.toString() + ", Supply: ";
    }
}
