package AnimalNursery.packAnimal;

import java.util.ArrayList;
import java.util.List;

public class Camel extends packAnimal {

    String name;
    private String dateBirth;
    List<String> commands = new ArrayList<>();

    public Camel(String name, String dateBirth) {
        super(name);
        this.name = name;
        this.dateBirth = dateBirth;

    }

    public String getName() {
        return String.format(name);
    }

    public void addCommand(String command) {
        if (!commands.contains(command)) {
            commands.add(command);
            System.out.println(name + " обучен(а) команде: " + command);
        } else {
            System.out.println("Питомец уже знает эту команду");
        }
    }

    public void getCommand(String command) {
        if (!commands.contains(command)) {
            commands.add(command);
            System.out.println(name + "выполнил(а) команду: " + command);
        } else {
            System.out.println("Питомец уже знает эту команду");
        }
    }


    @Override
    public String toString() {
        return String.format("Верблюд: %s, Дата рождения: %s", name, dateBirth);
    }

    public String printCommands() {
        return String.format("%s %s", super.printCommands(), String.join("; ", this.commands));
    }


}

