//Создать список из 50 персонажей выбранных случайным числом
// и статический метод выбирающий из списка только элементы конкретного, переданного в параметре класса и выводящий их описание в консоль!

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroesOne = new ArrayList<>();
        ArrayList<BaseHero> heroesTwo = new ArrayList<>();
        Random random = new Random();
        generateHeroes(heroesOne, 10, random, 1);
        generateHeroes(heroesTwo, 10, random, 2);
//        System.out.println(heroesOne);
        heroesOne.forEach(n -> System.out.print(n.getInfo() + ", "));
        heroesOne.forEach(n -> n.step(heroesOne));
//        chooseHero(heroes, "Mage");
//        ArrayList<BaseHero> farmer = new ArrayList<>();
//        String[] farmerNames = {"Михаил", "Иван"};
//        for (String name : farmerNames) {
//            farmer.add(new Farmer(name));
//        }
//        for (BaseHero character : farmer) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<BaseHero> rogue = new ArrayList<>();
//        String[] rogueNames = {"Михаил", "Иван"};
//        for (String name : rogueNames) {
//            rogue.add(new Rogue(name));
//        }
//        for (BaseHero character : rogue) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<BaseHero> sniper = new ArrayList<>();
//        String[] sniperNames = {"Михаил", "Иван"};
//        for (String name : sniperNames) {
//            sniper.add(new Sniper(name));
//        }
//        for (BaseHero character : sniper) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<BaseHero> crossbowman = new ArrayList<>();
//        String[] crossbowmanNames = {"Михаил", "Иван"};
//        for (String name : crossbowmanNames) {
//            crossbowman.add(new Crossbowman(name));
//        }
//        for (BaseHero character : crossbowman) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<BaseHero> spearman = new ArrayList<>();
//        String[] spearmanNames = {"Михаил", "Иван"};
//        for (String name : spearmanNames) {
//            spearman.add(new Spearman(name));
//        }
//        for (BaseHero character : spearman) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<BaseHero> mage = new ArrayList<>();
//        String[] mageNames = {"Михаил", "Иван"};
//        for (String name : mageNames) {
//            mage.add(new Mage(name));
//        }
//        for (BaseHero character : mage) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
//
//        ArrayList<BaseHero> monk = new ArrayList<>();
//        String[] monkNames = {"Михаил", "Иван"};
//        for (String name : monkNames) {
//            monk.add(new Monk(name));
//        }
//        for (BaseHero character : monk) {
//            System.out.println(character);
//        }
//        System.out.println("====================");
    }

    private static void generateHeroes(ArrayList<BaseHero> heroesList, int quantity, Random rand, int mode) {
        String[] namesList = {"Артём", "Александр", "Михаил", "Максим", "Иван", "Даниил", "Дмитрий", "Кирилл", "Никита", "Егор", "Матвей", "Андрей", "Илья", "Алексей", "Роман", "Сергей", "Владислав", "Ярослав", "Тимофей", "Арсений", "Денис", "Владимир", "Павел", "Глеб", "Константин", "Богдан", "Евгений", "Николай", "Степан", "Захар", "Тимур", "Марк", "Семён", "Фёдор", "Георгий", "Лев", "Антон", "Вадим", "Игорь", "Руслан", "Вячеслав", "Григорий", "Макар", "Артур", "Виктор", "Станислав", "Савелий", "Олег", "Давид", "Леонид", "Пётр", "Юрий", "Виталий", "Мирон", "Василий", "Всеволод", "Елисей", "Назар", "Родион", "Марат",
                "Платон", "Герман", "Игнат", "Святослав", "Анатолий", "Тихон", "Валерий", "Мирослав", "Ростислав", "Борис", "Филипп", "Демьян", "Гордей", "Валентин", "Демид", "Прохор", "Серафим", "Савва", "Яромир",
                "Аркадий", "Архип", "Тарас", "Трофим"};
        int namesSize = namesList.length;
        for (int i = 0; i < quantity; i++){
            int type = rand.nextInt(4);
            if (mode == 1){
                switch (type){
                    case 0 -> heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new Rogue(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Sniper(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Mage(namesList[rand.nextInt(namesSize)]));
                }
            } else {
                switch (type){
                    case 0 -> heroesList.add(new Crossbowman(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new Monk(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Spearman(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                }
            }
            }
        }
    }
//    private static void chooseHero(ArrayList<BaseHero> heroesList, String heroRole){
//        System.out.printf("List of %s roles\n", heroRole);
//        for (BaseHero hero : heroesList){
//            if (hero.toString().contains(heroRole)){
//                System.out.println(hero);
//            }
//        }
//    }
//}
