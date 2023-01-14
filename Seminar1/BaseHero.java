import java.util.Arrays;

public class BaseHero {
    String name, role;
    int attack, defence, health, speed;
    int[] damage;

    public BaseHero(String name, String role, int attack, int defence, int[] damage, int health, int speed) {
        this.name = name;
        this.role = role;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + role + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " + Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed;
    }
}
