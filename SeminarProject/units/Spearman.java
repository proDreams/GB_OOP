package units;

import java.util.ArrayList;

public class Spearman extends Melee {
    public Spearman(ArrayList<BaseHero> teamList, String name, int x, int y){
        super(teamList, name, "Spearman", 4, 5, new int[] {1, 3}, 10, 4, x, y);
    }
}
