//Создать список из 50 персонажей выбранных случайным числом
// и статический метод выбирающий из списка только элементы конкретного, переданного в параметре класса и выводящий их описание в консоль!

import units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroesOne = new ArrayList<>();
        ArrayList<BaseHero> heroesTwo = new ArrayList<>();
        Random random = new Random();
        generateHeroes(heroesOne, 10, random, 1);
        generateHeroes(heroesTwo, 10, random, 2);
        heroesOne.forEach(n -> System.out.print(n.getInfo() + ", "));
        heroesOne.forEach(n -> n.step(heroesOne));
//        chooseHero(heroes, "units.Mage");
//        ArrayList<units.BaseHero> farmer = new ArrayList<>();
//        String[] farmerNames = {"Михаил", "Иван"};
//        for (String name : farmerNames) {
//            farmer.add(new units.Farmer(name));
//        }
//        for (units.BaseHero character : farmer) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<units.BaseHero> rogue = new ArrayList<>();
//        String[] rogueNames = {"Михаил", "Иван"};
//        for (String name : rogueNames) {
//            rogue.add(new units.Rogue(name));
//        }
//        for (units.BaseHero character : rogue) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<units.BaseHero> sniper = new ArrayList<>();
//        String[] sniperNames = {"Михаил", "Иван"};
//        for (String name : sniperNames) {
//            sniper.add(new units.Sniper(name));
//        }
//        for (units.BaseHero character : sniper) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<units.BaseHero> crossbowman = new ArrayList<>();
//        String[] crossbowmanNames = {"Михаил", "Иван"};
//        for (String name : crossbowmanNames) {
//            crossbowman.add(new units.Crossbowman(name));
//        }
//        for (units.BaseHero character : crossbowman) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<units.BaseHero> spearman = new ArrayList<>();
//        String[] spearmanNames = {"Михаил", "Иван"};
//        for (String name : spearmanNames) {
//            spearman.add(new units.Spearman(name));
//        }
//        for (units.BaseHero character : spearman) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<units.BaseHero> mage = new ArrayList<>();
//        String[] mageNames = {"Михаил", "Иван"};
//        for (String name : mageNames) {
//            mage.add(new units.Mage(name));
//        }
//        for (units.BaseHero character : mage) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<units.BaseHero> monk = new ArrayList<>();
//        String[] monkNames = {"Михаил", "Иван"};
//        for (String name : monkNames) {
//            monk.add(new units.Monk(name));
//        }
//        for (units.BaseHero character : monk) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
    }

    private static void generateHeroes(ArrayList<BaseHero> heroesList, int quantity, Random rand, int mode) {
        String[] namesList = {"Артём", "Александр", "Михаил", "Максим", "Иван", "Даниил", "Дмитрий", "Кирилл", "Никита", "Егор", "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей", "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис", "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений", "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён", "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Руслан", "Вячеслав", "Григорий", "Макар", "Артур", "Виктор", "Станислав", "Савелий", "Олег", "Давид", "Леонид", "Пётр", "Юрий", "Виталий", "Мирон", "Василий", "Всеволод", "Елисей", "Назар", "Родион", "Марат",
                "Платон", "Герман", "Игнат", "Святослав", "Анатолий", "Тихон", "Валерий", "Мирослав", "Ростислав", "Борис", "Филипп", "Демьян", "Гордей", "Валентин", "Демид", "Прохор", "Серафим", "Савва", "Яромир",
                "Аркадий", "Архип", "Тарас", "Трофим"};
        int namesSize = namesList.length;
        for (int i = 0; i < quantity; i++) {
            int type = rand.nextInt(4);
            if (mode == 1) {
                switch (type) {
                    case 0 -> heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
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
    }
}
//    private static void chooseHero(ArrayList<units.BaseHero> heroesList, String heroRole){
//        System.out.printf("List of %s roles\n", heroRole);
//        for (units.BaseHero hero : heroesList){
//            if (hero.toString().contains(heroRole)){
//                System.out.println(hero);
//            }
//        }
//    }
//}
