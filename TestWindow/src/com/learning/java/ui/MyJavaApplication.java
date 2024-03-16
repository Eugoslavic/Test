package com.learning.java.ui;

public class MyJavaApplication {
	public static void main(String[] args) {
		MyWindow window = new MyWindow();
		window.addCanvas();
		window.addButton("Okay");
		window.addSpinner();
		window.open();
		
	}
	


}
