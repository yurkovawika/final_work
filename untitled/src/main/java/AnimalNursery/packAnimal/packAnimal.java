package AnimalNursery.packAnimal;

import AnimalNursery.Animal;

public abstract class packAnimal extends Animal {
    private final String name;

    public packAnimal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
