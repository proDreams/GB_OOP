package units;

import java.util.ArrayList;

public class Mage extends Healers {
    public Mage(ArrayList<BaseHero> teamList, String name, int x, int y, String team, boolean status){
        super(teamList, name, "Mage", "\uD83E\uDE84", 17, 12, new int[] {-5, -5}, 30, 9, 1, x,y, team, status);
    }

}
