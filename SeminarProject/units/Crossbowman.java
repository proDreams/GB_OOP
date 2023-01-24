package units;

import java.util.ArrayList;

public class Crossbowman extends Ranged {
    public Crossbowman(ArrayList<BaseHero> teamList, String name, int x, int y) {
        super(teamList, name, "Crossbowman", 12, 10, new int[]{8, 10}, 15, 9, 16, x, y);
    }
}
