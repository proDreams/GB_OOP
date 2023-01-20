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
        boolean doShoot = true;
        for (BaseHero hero : heroList) {
            if (hero.role.equals("Farmer")) {
                if (((Farmer) hero).supply) {
                    System.out.printf("\nПерсонаж %s %s совершил выстрел и потратил 0 стрел. Осталось стрел %d/%d", name, role, shoots, maxShoots);
                    ((Farmer) hero).supply = false;
                    doShoot = false;
                    break;
                }
            }
        }
        if (doShoot) {
            if (shoots > 0) {
                System.out.printf("\nПерсонаж %s %s совершил выстрел и потратил 1 стрелу. Осталось стрел %d/%d", name, role, --shoots, maxShoots);
            } else {
                System.out.printf("\nПерсонаж %s %s не может больше стрелять. Закончились стрелы %d/%d", name, role, shoots, maxShoots);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots: " + shoots + ", Max Shoots: " + maxShoots;
    }
}
