package AnimalNursery;

// Базовый класс животного
public abstract class Animal {

    public abstract void addCommand(String command);

    public abstract String getName();


    public abstract String toString();

    public String printCommands() {
        return String.format("Знает команды:");
    }


}
