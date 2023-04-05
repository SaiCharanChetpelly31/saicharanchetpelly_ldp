package com.java.solid.lsp;

class AnimalSound {
    public void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        AnimalSound animalSound = new AnimalSound();
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Bird();

        animalSound.makeAnimalSound(animal1); // outputs "Woof"
        animalSound.makeAnimalSound(animal2); // outputs "Meow"
        animalSound.makeAnimalSound(animal3); // outputs "Chirp"
    }
}
