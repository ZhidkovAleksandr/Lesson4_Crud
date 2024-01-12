package org.example;

import Entity.Animal;

public class Main {
    public static void main(String[] args) {

        Animal cat = new Animal();
        cat.setName("Vaska");
        cat.setTail(true);
        cat.setAge(2);

        AnimalHelper animalHelper = new AnimalHelper();

        animalHelper.add(cat);

        Animal v = animalHelper.getById(1);
        System.out.println(v);

        animalHelper.remove(v);
        animalHelper.emf.close();

    }
}