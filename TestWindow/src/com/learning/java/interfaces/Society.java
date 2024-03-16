package com.learning.java.interfaces;

public class Society {
	
	public static void main(String [] args) {
		Person me = new Person();
		Mother mother = me;
		Daughter daughter = me;
		mother.beMotherly();
		daughter.beDaughterly();
	}

}
