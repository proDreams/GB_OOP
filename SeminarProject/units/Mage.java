package units;

import java.util.ArrayList;

public class Mage extends Healers {
    public Mage(ArrayList<BaseHero> teamList, String name, int x, int y){
        super(teamList, name, "Mage", 17, 12, new int[] {-5, -5}, 30, 9, 1, x,y);
    }

}
