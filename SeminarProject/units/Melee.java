package units;

import java.util.ArrayList;

public class Melee extends BaseHero {
    public Melee(ArrayList<BaseHero> teamList, String name, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y) {
        super(teamList, name, role, attack, defence, damage, health, speed, x, y);
    }
}
