package units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
    protected String name, role, icon;
    protected int attack, defence, maxHealth, speed;
    protected float health;
    protected int[] damage;
    protected ArrayList<BaseHero> teamList;
    private Vector2 position;


    public BaseHero(ArrayList<BaseHero> teamList, String name, String role, String icon, int attack, int defence, int[] damage, int health, int speed, int x, int y) {
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
    }

    public int getHealth() {
        return (int) health / maxHealth * 100;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
    }

    @Override
    public String getInfo() {
//        return name + " " + role + " ♥️: " + health + "/" + maxHealth + ", ⚔️: " + attack;
        return String.format("%-10s %-13s%-3s %s: %-3d/ %-3d %s: %-5d |", name, role, icon, "\uD83E\uDDE1", (int) health, maxHealth, "⚔", attack);
    }
//    public String getInfo(){
//        String outStr = String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥️%.1f\t☠️%d", attack,defence,health,(damage[0] + damage[1])/2,speed);
//        return outStr;
//    }

    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + role + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed;
    }

    public Vector2 getPosition() {
        return position;
    }

    public String getName() {
        return role;
    }

    protected void getDamage(float attackPower){
        this.health -= attackPower;
        if (this.health < 0){
            this.health = 0;
        } else if (this.health > maxHealth){
            this.health = maxHealth;
        }
    }
    public float heroHP(){
        return health;
    }
}
