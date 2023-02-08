package units;

import java.util.ArrayList;

public class Sniper extends Ranged {
    public Sniper(ArrayList<BaseHero> teamList, String name, int x, int y, String team, boolean status) {
        super(teamList, name, "Sniper", "\uD83C\uDFF9", 12, 10, new int[]{8, 10}, 15, 9, 32, x, y, team, status);
    }
}
