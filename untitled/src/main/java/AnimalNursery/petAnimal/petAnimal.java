package AnimalNursery.petAnimal;

import AnimalNursery.Animal;


public abstract class petAnimal extends Animal {
    private String name;


    public petAnimal(String name) {
        this.name = name;

    }


    public String print() {
        return String.format("name: %s", name);
    }
}
