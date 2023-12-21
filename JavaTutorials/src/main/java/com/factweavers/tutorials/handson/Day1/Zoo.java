package com.factweavers.tutorials.handson.Day1;

import java.util.*;

public class Zoo {
    private List<Animal> animals;
    private ArrayList<String> animalList;
    Zoo(){
        this.animals=new ArrayList<>();
        this.animalList=new ArrayList<String>();
    }



    public void addAnimal(Animal animal) {
        animals.add(animal);

    }

    public void setAnimalAsDead(Animal animal){
        animal.setIsAlive(false);
    }
    public void sortAnimals(){
        Collections.sort(animals,new Comparator<Animal>() {
            @Override
            public int compare(Animal s1, Animal s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });

    }

    public  void countAnimals(String type){

        int count = 0;
        for(Animal animal: animals){
            if(animal.getType().equalsIgnoreCase(type) && animal.getIsAlive()) {
                count++;
            }

        }
        System.out.println("Number of "+type+" : "+count);

    }
    void showAnimals(){
        System.out.println("These are the Animals present in the ZOO");
        for(Animal animal:animals){

            System.out.println(animal);
        }
    }
    void sortAnimalsBasedOnType(String type){
        for(Animal animal:animals){
            if(type.equalsIgnoreCase(animal.getType())){
                animalList.add(animal.getName());

            }
        }
        Collections.sort(animalList);
        System.out.println(type+" in Sorted order : "+ animalList);
    }
}
