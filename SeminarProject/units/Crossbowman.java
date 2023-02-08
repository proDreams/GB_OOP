package units;

import java.util.ArrayList;

public class Crossbowman extends Ranged {
    public Crossbowman(ArrayList<BaseHero> teamList, String name, int x, int y, String team, boolean status) {
        super(teamList, name, "Crossbowman", "\uD83C\uDFF9", 12, 10, new int[]{8, 10}, 15, 9, 16, x, y, team, status);
    }
}
