package units;

import java.util.ArrayList;

public class Rogue extends Melee {
    public Rogue(ArrayList<BaseHero> teamList, String name, int x, int y, String team, boolean status){
        super(teamList, name, "Rogue", "⚔️", 8, 3, new int[] {2, 4}, 10, 6, x, y, team, status);
    }
}
