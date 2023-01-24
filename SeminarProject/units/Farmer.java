package units;

import java.util.ArrayList;

public class Farmer extends BaseHero {
    protected boolean supply;

    public Farmer(ArrayList<BaseHero> teamList, String name, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y) {
        super(teamList, name, role, attack, defence, damage, health, speed, x, y);
    }

    public Farmer(ArrayList<BaseHero> teamList, String name, int x, int y) {
        super(teamList, name, "Farmer", 1, 1, new int[]{1, 1}, 1, 3, x, y);
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
