package units;

import java.util.ArrayList;

public class Ranged extends BaseHero {
    int shoots, maxShoots;

    public Ranged(ArrayList<BaseHero> teamList, String name, String role, String icon, int attack, int defence, int[] damage, int health, int speed, int shoots, int x, int y, String team, boolean status) {
        super(teamList, name, role, icon, attack, defence, damage, health, speed, x, y, team, status);
        this.shoots = shoots;
        this.maxShoots = shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health == 0){
            return;
        }
        Vector2 target = getTarget(heroList);
        float constMin = 12;
        float constMax = 4;

        float attackPower;
        if (target.x <= constMax) {
            attackPower = damage[1];

        } else if (target.x >= constMin) {
            attackPower = damage[0];
        } else {
            attackPower = damage[0] + ((target.x - constMax) / (constMin - constMax)) * (damage[1] - damage[0]);
        }

        boolean doShoot = true;
        for (BaseHero hero : heroList) {
            if (hero.role.equals("Farmer")) {
                if (((Farmer) hero).supply) {
                    heroList.get((int) target.y).getDamage(attackPower);
                    System.out.printf("\nПерсонаж %s %s совершил выстрел в персонажа %s %s нанёс %d урона и потратил 0 стрел. Осталось стрел %d/%d", name, role, heroList.get((int) target.y).name, heroList.get((int) target.y).role, (int) attackPower, shoots, maxShoots);
                    ((Farmer) hero).supply = false;
                    doShoot = false;
                    break;
                }
            }
        }
        if (doShoot) {
            if (shoots > 0) {
                heroList.get((int) target.y).getDamage(attackPower);
                System.out.printf("\nПерсонаж %s %s совершил выстрел в персонажа %s %s нанёс %d урона и потратил 1 стрелу. Осталось стрел %d/%d", name, role, heroList.get((int) target.y).name, heroList.get((int) target.y).role, (int) attackPower, --shoots, maxShoots);
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
