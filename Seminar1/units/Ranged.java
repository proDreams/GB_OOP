package units;

import java.util.ArrayList;

public class Ranged extends BaseHero {
    int shoots, maxShoots;

    public Ranged(String name, String role, int attack, int defence, int[] damage, int health, int speed, int shoots) {
        super(name, role, attack, defence, damage, health, speed);
        this.shoots = shoots;
        this.maxShoots = shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        int freeFarmers = 0;
        for (BaseHero hero : heroList){
            if (hero.role.equals("Farmer")) {
                if (((Farmer) hero).supply) {
                    freeFarmers++;
                }
            }
        }
        for (BaseHero hero : heroList) {
            if (freeFarmers > 0){
                if (hero.role.equals("Farmer")) {
                    if (((Farmer) hero).supply) {
                        System.out.printf("\nПерсонаж %s %s совершил выстрел и потратил 0 стрел. Осталось стрел %d/%d", name, role, shoots, maxShoots);
                        ((Farmer) hero).supply = false;
                        break;
                    }
                }
            } else {
                System.out.printf("\nПерсонаж %s %s совершил выстрел и потратил 1 стрелу. Осталось стрел %d/%d", name, role, --shoots, maxShoots);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots: " + shoots + ", Max Shoots: " + maxShoots;
    }
}
