package com.java.learning.interfaces;

public class Dog extends Pet {
	
    public Dog(String name) {
		super(name);
	}

	@Override
	public void greet() {
		System.out.println("Woof");
		
	}

}
