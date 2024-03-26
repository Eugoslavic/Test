package com.java.learning.interfaces;

public class AnimalGreetings {


    public static void main(String[] args) {
        DomesticPet[] pets = new DomesticPet[10];
        pets[0] = new Dog("Buddy");
        pets[1] = new Cat("Whiskers");
        pets[2] = new Parrot("Polly");
        pets[3] = new Dog("Max");
        pets[4] = new Cat("Mittens");
        pets[5] = new Parrot("Rio");
        pets[6] = new Dog("Charlie");
        pets[7] = new Cat("Smokey");
        pets[8] = new Parrot("Kiwi");
        pets[9] = new Dog("Bailey");

        for (DomesticPet pet : pets) {
            pet.greet();
        }
    }

}

	
	
	
