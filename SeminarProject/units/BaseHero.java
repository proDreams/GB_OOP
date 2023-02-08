package units;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseHero implements BaseInterface {
    protected String name, role, icon, team;
    protected int attack, defence, maxHealth, speed;
    protected float health;
    protected int[] damage;
    protected ArrayList<BaseHero> teamList;
    private Vector2 position;
    protected boolean status;


    public BaseHero(ArrayList<BaseHero> teamList, String name, String role, String icon, int attack, int defence, int[] damage, int health, int speed, int x, int y, String team, boolean status) {
        this.teamList = teamList;
        this.name = name;
        this.role = role;
        this.icon = icon;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth;
        this.speed = speed;
        this.position = new Vector2(x, y);
        this.team = team;
        this.status = status;
    }

    public int getHealth() {
        return (int) health / maxHealth * 100;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
    }

    @Override
    public String getInfo() {
        return String.format("%-10s %-13s%-3s %s: %-3d/ %-3d %s: %-5d |", name, role, icon, "\uD83E\uDDE1", (int) health, maxHealth, "⚔", attack);
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + role + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    protected void getDamage(float attackPower) {
        this.health -= attackPower;
        if (this.health < 0) {
            this.health = 0;
        } else if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    public float heroHP() {
        return health;
    }

    protected Vector2 getTarget(ArrayList<BaseHero> heroList) {
        float minDistance = 100;
        int minIndex = 0;
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).getTeam().equals(getTeam())) {
                continue;
            }
            float temp = getPosition().getDistance(heroList.get(0).getPosition().x, heroList.get(0).getPosition().y);
            if (temp < minDistance && heroList.get(i).health > 0) {
                minDistance = temp;
                minIndex = i;
            }
        }
        return new Vector2(minDistance, minIndex);
    }

    public void setPosition(float x, float y) {
        this.position = new Vector2(x, y);
    }

    public String getTeam() {
        return team;
    }

    public boolean getStatus() {
        return status;
    }

    public int getSpeed() {
        return speed;
    }
}
