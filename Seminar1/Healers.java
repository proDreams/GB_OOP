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
    public void step(ArrayList<BaseHero> heroList, BaseHero hero) {
        double max = 0;
        int maxi = 0;
        for (int i = 0; i < heroList.size(); i++) {
            String[] params = heroList.get(i).getInfo().split(" ");
            if (Integer.parseInt(params[1]) != Integer.parseInt(params[2]) ){
                double temp = Double.parseDouble(params[1]) / Double.parseDouble(params[2]) * 100;
                if (temp > max){
                    max = temp;
                    maxi = i;
                }
            }
        }
        healing(hero, heroList.get(maxi));
    }

    private static void healing(BaseHero hero, BaseHero weak){
        int currentHealth = weak.health;
        int healingPower = hero.damage[0];
        if (Math.abs(healingPower - currentHealth) > weak.maxHealth){
            weak.health = weak.maxHealth;
            System.out.printf("\nПерсонаж %s %s вылечил персонажа %s %s полностью. Текущее здоровье: %d/%d", hero.name, hero.role, weak.name, weak.role, weak.health, weak.maxHealth);
        } else {
            weak.health = Math.abs(healingPower - currentHealth);
            System.out.printf("\nПерсонаж %s %s вылечил персонажа %s %s на %d ед. здоровья. Текущее здоровье: %d/%d", hero.name, hero.role, weak.name, weak.role, Math.abs(hero.damage[0]), weak.health, weak.maxHealth);
        }
    }
}
