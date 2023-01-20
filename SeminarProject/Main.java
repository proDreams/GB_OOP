import units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<BaseHero> heroesOne = new ArrayList<>();
        ArrayList<BaseHero> heroesTwo = new ArrayList<>();
        Random random = new Random();
        generateHeroes(heroesOne, 10, random, 1);
        generateHeroes(heroesTwo, 10, random, 2);
        while (true){
            heroesOne.forEach(n -> System.out.print(n.getInfo() + ", "));
            heroesOne.forEach(n -> n.step(heroesOne));
            System.out.println();
            input.nextLine();
        }
    }

    private static void generateHeroes(ArrayList<BaseHero> heroesList, int quantity, Random rand, int mode) {
        String[] namesList = {"Артём", "Александр", "Михаил", "Максим", "Иван", "Даниил", "Дмитрий", "Кирилл", "Никита", "Егор", "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей", "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис", "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений", "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён", "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Руслан", "Вячеслав", "Григорий", "Макар", "Артур", "Виктор", "Станислав", "Савелий", "Олег", "Давид", "Леонид", "Пётр", "Юрий", "Виталий", "Мирон", "Василий", "Всеволод", "Елисей", "Назар", "Родион", "Марат",
                "Платон", "Герман", "Игнат", "Святослав", "Анатолий", "Тихон", "Валерий", "Мирослав", "Ростислав", "Борис", "Филипп", "Демьян", "Гордей", "Валентин", "Демид", "Прохор", "Серафим", "Савва", "Яромир",
                "Аркадий", "Архип", "Тарас", "Трофим"};
        int namesSize = namesList.length;
        ArrayList<BaseHero> farmers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int type = rand.nextInt(4);
            if (mode == 1) {
                switch (type) {
                    case 0 -> farmers.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new Rogue(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Sniper(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Mage(namesList[rand.nextInt(namesSize)]));
                }
            } else {
                switch (type) {
                    case 0 -> heroesList.add(new Crossbowman(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new Monk(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Spearman(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                }
            }
        }
        heroesList.addAll(farmers);
    }
}