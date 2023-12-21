package com.factweavers.tutorials.handson.Day1;
import java.lang.*;

public class ZooManager {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Animal parrot = new Bird("Parrot", "Bird", 5);
        Animal pigeon = new Bird("Pigeon", "Bird", 2);
        Animal snake = new Reptile("snake", "Reptiles", 10);
        Animal lizard = new Reptile("lizard", "Reptiles", 12);
        // System.out.println(parrot);
        zoo.addAnimal(parrot);
        zoo.addAnimal(pigeon);
        zoo.addAnimal(snake);
        zoo.addAnimal(lizard);
        zoo.setAnimalAsDead(snake);
        zoo.countAnimals("Reptiles");
        zoo.sortAnimals();
        zoo.showAnimals();
        zoo.sortAnimalsBasedOnType("reptiles");

    }

}
