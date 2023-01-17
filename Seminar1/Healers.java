import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Healers extends BaseHero {
    int mana;

    public Healers(String name, String role, int attack, int defence, int[] damage, int health, int speed, int mana) {
        super(name, role, attack, defence, damage, health, speed);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }


    @Override
    public void step(ArrayList<BaseHero> heroList) {
//        ArrayList<Double> reduceHealth = new ArrayList<>();
        double max = 0;
        int maxi = 0;
        for (int i = 0; i < heroList.size(); i++) {
            String[] params = heroList.get(i).getInfo().split(" ");
            if (Integer.parseInt(params[1]) != Integer.parseInt(params[2]) ){
                double temp = Double.parseDouble(params[2]) / Double.parseDouble(params[1]) * 100;
                if (temp > max){
                    max = temp;
                    maxi = i;
                }
            }
        }
//        Double max = Collections.max(reduceHealth);
        System.out.println();
        System.out.println(max);
        System.out.println(maxi);
    }
}
