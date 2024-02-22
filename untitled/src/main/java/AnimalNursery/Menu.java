package AnimalNursery;

import AnimalNursery.packAnimal.*;
import AnimalNursery.petAnimal.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;

public class Menu {
    static List<Animal> animals = new ArrayList<>();

    public static int petCount = 0;
    public static int packCount = 0;

    public static void main(String[] args) {
    }

    public static void MenuAnimals() throws IOException, InputMismatchException {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.print("""
                    Menu:
                    \t1. Вывести список всех питомцев;
                    \t2. Добавить нового питомца;
                    \t3. Команды, которые знают питомцы
                    \t4. Научить питомца новой команде;
                    \t5. Удалить питомца;
                    \t0. Выход

                    ***Введите свой выбор----->>\s""");

            try {
                int choice = in.nextInt();
                switch (choice) {
                    case 1 -> { //Посмотреть информацию о всех животных
                        System.out.printf("""
                                В питомнике сейчас домашних животных: %d
                                                            
                                Вьючных животных: %d
                                """, petCount, packCount);
                        for (Animal animal : animals)
                            System.out.println(animal.toString());
                    }
                    case 2 -> {//Добавить новое животное
                        System.out.print("""
                                \t1. Кошка;
                                \t2. Собака;
                                \t3. Хомяк;
                                \t4. Лошадь;
                                \t5. Верблюд;
                                \t6. Осёл;
                                \t0. Выход

                                Введите номер животного, которого хотите добавить ----->>"\s""");

                        addNewAnimal(in.nextInt());
                    }

                    case 3 -> {//Показать список команд, которые знают животные
                        if (animals.size() == 0) {
                            System.out.println("На данный момент в питомнике нет животных:\n");
                        } else {
                            for (Animal animal : animals) {
                                System.out.println(animal.getName());
                                System.out.println(animal.printCommands());
                                System.out.println("---------------------------------------");

                            }
                        }
                    }
                    case 4 -> //Дрессировка животного
                            newCommand();
                    case 5 -> {  //Убрать животное из питомника
                        if (animals.size() == 0) {
                            System.out.println("На данный момент в питомнике нет животных:\n");
                        } else {
                            System.out.print("Введите номер питомца для его удаления -->> ");
                            int number = in.nextInt() - 1;
                            if (animals.get(number).getClass() == petAnimal.class) {
                                animals.remove(number);
                                petCount--;
                            } else {
                                animals.remove(number);
                                packCount--;
                            }
                        }
                    }
                    case 0 -> { // выход
                        in.close();
                        return;
                    }
                }
            } catch (InputMismatchException | NumberFormatException | IndexOutOfBoundsException e) {
                MenuAnimals();
            }
        }
    }


    public static void addNewAnimal(int i) throws NumberFormatException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кличку и дату рождения нового питомца(через enter):");

        switch (i) {
            case 1 -> {
                Menu.animals.add((new Cat(in.nextLine(), in.nextLine())));
                petCount++;
            }
            case 2 -> {
                Menu.animals.add(new Dog(in.nextLine(), in.nextLine()));
                petCount++;
            }
            case 3 -> {
                Menu.animals.add(new Hamster(in.nextLine(), in.nextLine()));
                petCount++;
            }
            case 4 -> {
                Menu.animals.add(new Horse(in.nextLine(), in.nextLine()));
                packCount++;
            }
            case 5 -> {
                Menu.animals.add(new Camel(in.nextLine(), in.nextLine()));
                packCount++;
            }
            case 6 -> {
                Menu.animals.add(new Donkey(in.nextLine(), in.nextLine()));
                packCount++;
            }
            case 0 -> MenuAnimals();
        }

    }

    public static void newCommand() {
        Scanner num = new Scanner(System.in);

        if (animals.size() == 0) {
            System.out.println("-Нет питомцев для обучения-");

        } else {
            System.out.print("Введите номер питомца для обучения:\n");
            for (int i = 0; i < animals.size(); i++) {
                System.out.println(i + 1 + ")" + animals.get(i).getName());
            }

            int name = num.nextInt();


            if (animals.size() >= name) {
                String[] commands = new String[]{"Голос", "Ко мне", "Сидеть", "Место"};
                System.out.print("""
                        \t1. Голос;
                        \t2. Ко мне;
                        \t3. Сидеть;
                        \t4. Место;
                        \t0. Выход в меню
                        ***Введите номер выбранной команды ----->>\s""");
                int i = num.nextInt();
                String command = commands[i - 1];
                animals.get(name - 1).addCommand(command);
            }
        }
    }
}





