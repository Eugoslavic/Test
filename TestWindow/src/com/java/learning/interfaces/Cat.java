package com.java.learning.interfaces;

public class Cat extends Pet implements DomesticPet {
	
    public Cat(String name) {
		super(name);
		
	}

	@Override
	public void greet() {
		System.out.println("Meow");
		
	}

}
