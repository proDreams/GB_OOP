package units;

import java.util.ArrayList;
import java.util.Random;

public class Healers extends BaseHero {
    int mana;

    public Healers(ArrayList<BaseHero> teamList, String name, String role, String icon, int attack, int defence, int[] damage, int health, int speed, int mana, int x, int y, String team, boolean status) {
        super(teamList, name, role, icon, attack, defence, damage, health, speed, x, y, team, status);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: ";
    }


    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health == 0) {
            return;
        }
        if (status) {
            status = false;
            return;
        }

        int max = 100;
        int maxi = 0;
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).getTeam().equals(getTeam())) {
                if (heroList.get(i).health == 0) {
                    System.out.printf("\nПерсонаж %s %s воскресил персонажа %s %s В виде: ", name, role, heroList.get(i).name, heroList.get(i).role);
                    resurrect(i, heroList);
                    return;
                }
                int currentHealth = heroList.get(i).getHealth();
                if (currentHealth < 100) {
                    if (currentHealth < max) {
                        max = currentHealth;
                        maxi = i;
                    }
                }
            } else {
                continue;
            }
        }
        if (max < 100) {
            healing(heroList.get(maxi));
        }
    }

    private void healing(BaseHero weak) {
        float healingPower = damage[0];
        weak.getDamage(healingPower);
        if (weak.health == weak.maxHealth) {
            System.out.printf("\nПерсонаж %s %s вылечил персонажа %s %s полностью. Текущее здоровье: %d/%d", name, role, weak.name, weak.role, (int) weak.health, weak.maxHealth);
        } else {
            System.out.printf("\nПерсонаж %s %s вылечил персонажа %s %s на %d ед. здоровья. Текущее здоровье: %d/%d", name, role, weak.name, weak.role, (int) Math.abs(healingPower), (int) weak.health, weak.maxHealth);
        }
    }

    private void resurrect(int index, ArrayList<BaseHero> heroList) {
        String[] namesList = {"Артём", "Александр", "Михаил", "Максим", "Иван", "Даниил", "Дмитрий", "Кирилл", "Никита", "Егор", "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей", "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис", "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений", "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён", "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Руслан", "Вячеслав", "Григорий", "Макар", "Артур", "Виктор", "Станислав", "Савелий", "Олег", "Давид", "Леонид", "Пётр", "Юрий", "Виталий", "Мирон", "Василий", "Всеволод", "Елисей", "Назар", "Родион", "Марат",
                "Платон", "Герман", "Игнат", "Святослав", "Анатолий", "Тихон", "Валерий", "Мирослав", "Ростислав", "Борис", "Филипп", "Демьян", "Гордей", "Валентин", "Демид", "Прохор", "Серафим", "Савва", "Яромир",
                "Аркадий", "Архип", "Тарас", "Трофим"};
        int namesSize = namesList.length;
        int posX = (int) heroList.get(index).getPosition().x;
        int posY = (int) heroList.get(index).getPosition().y;
        status = true;
        String heroTeam = heroList.get(index).getTeam();
        Random random = new Random();
        if (heroTeam.equals("white")) {
            switch (random.nextInt(4)) {
                case 0 ->
                        heroList.set(index, new Farmer(teamList, namesList[random.nextInt(namesSize)], posX, posY, "white", false));
                case 1 ->
                        heroList.set(index, new Rogue(teamList, namesList[random.nextInt(namesSize)], posX, posY, "white", false));
                case 2 ->
                        heroList.set(index, new Sniper(teamList, namesList[random.nextInt(namesSize)], posX, posY, "white", false));
                case 3 ->
                        heroList.set(index, new Mage(teamList, namesList[random.nextInt(namesSize)], posX, posY, "white", false));
            }
        } else {
            switch (random.nextInt(4)) {
                case 0 ->
                        heroList.set(index, new Crossbowman(teamList, namesList[random.nextInt(namesSize)], posX, posY, "dark", false));
                case 1 ->
                        heroList.set(index, new Monk(teamList, namesList[random.nextInt(namesSize)], posX, posY, "dark", false));
                case 2 ->
                        heroList.set(index, new Spearman(teamList, namesList[random.nextInt(namesSize)], posX, posY, "dark", false));
                case 3 ->
                        heroList.set(index, new Farmer(teamList, namesList[random.nextInt(namesSize)], posX, posY, "dark", false));
            }
        }
        System.out.printf("%s %s\n", heroList.get(index).name, heroList.get(index).role);
    }
}
