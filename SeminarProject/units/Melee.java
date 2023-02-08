package units;

import java.util.ArrayList;
import java.util.Random;

public class Melee extends BaseHero {
    public Melee(ArrayList<BaseHero> teamList, String name, String role, String icon, int attack, int defence, int[] damage, int health, int speed, int x, int y, String team, boolean status) {
        super(teamList, name, role, icon, attack, defence, damage, health, speed, x, y, team, status);
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health == 0) {
            return;
        }
        Vector2 target = getTarget(heroList);
        if (target.x == 100) {
            return;
        }
        // Нашли ближайшего врага.
        int targetX = (int) heroList.get((int) target.y).getPosition().x;
        int targetY = (int) heroList.get((int) target.y).getPosition().y;
        boolean targetLeft = targetX < getPosition().x;
        boolean targetRight = targetX > getPosition().x;
        boolean targetUp = targetY > getPosition().y;
        boolean targetDown = targetY < getPosition().y;
        float attackPower = new Random().nextInt(damage[0], damage[1] + 1);

        if (target.x < 2) {
            heroList.get((int) target.y).getDamage(attackPower);
        } else if (targetRight) {
            setPosition(++getPosition().x, getPosition().y);
        } else if (targetLeft) {
            setPosition(--getPosition().x, getPosition().y);
        } else if (targetX == getPosition().x) {
            if (targetUp) {
                setPosition(getPosition().x, ++getPosition().y);
            } else if (targetDown) {
                setPosition(getPosition().x, --getPosition().y);
            }
        }
    }
}
