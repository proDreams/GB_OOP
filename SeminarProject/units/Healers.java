package units;

import com.sun.tools.javac.Main;

import java.util.ArrayList;

public class Healers extends BaseHero {
    int mana;

    public Healers(ArrayList<BaseHero> teamList, String name, String role, int attack, int defence, int[] damage, int health, int speed, int mana, int x, int y) {
        super(teamList, name, role, attack, defence, damage, health, speed, x, y);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }


    @Override
    public void step(ArrayList<BaseHero> heroList) {
        int max = 100;
        int maxi = 0;
        for (int i = 0; i < teamList.size(); i++) {
            int currentHealth = teamList.get(i).getHealth();
            if (currentHealth < 100) {
                if (currentHealth < max) {
                    max = currentHealth;
                    maxi = i;
                }
            }
        }
        if (max < 100){
            healing(teamList.get(maxi));
        }
    }

    private void healing(BaseHero weak) {
        int currentHealth = weak.health;
        int healingPower = damage[0];
        if (Math.abs(healingPower - currentHealth) > weak.maxHealth) {
            weak.health = weak.maxHealth;
            System.out.printf("\nПерсонаж %s %s вылечил персонажа %s %s полностью. Текущее здоровье: %d/%d", name, role, weak.name, weak.role, weak.health, weak.maxHealth);
        } else {
            weak.health = Math.abs(healingPower - currentHealth);
            System.out.printf("\nПерсонаж %s %s вылечил персонажа %s %s на %d ед. здоровья. Текущее здоровье: %d/%d", name, role, weak.name, weak.role, Math.abs(healingPower), weak.health, weak.maxHealth);
        }
    }
}
