package com.learning.java.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Drawing extends Canvas {
	private Color color;
	
	private Rectangle circleBounds = new Rectangle(0,0,100,100);

	public Drawing(Color color) {
		this.color = color;
		Runnable runable = new Runnable() {

			@Override
			public void run() {
				moveBall2();
				
			}
			
		};
		Thread backgroundThread = new Thread(runable);
		backgroundThread.start();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void paint(Graphics g) {
		Rectangle bounds = this.getBounds();
		g.setColor(color);
		g.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);

		g.fillOval(circleBounds.x, circleBounds.y, circleBounds.width, circleBounds.height);

	}

	private void moveBall2() {
	    int canvasWidth = getWidth();
	    int canvasHeight = getHeight();
	    int width = circleBounds.width;
	    int height = circleBounds.height;

	    int x = circleBounds.x + 36;
	    int y = circleBounds.y + 72;
	    int dx = 12; 
	    int dy = 8; 

	    while (true) {

	    
	        if (x < 0 || x + width > canvasWidth) {
	            dx = -dx; 
	          
	        }
	        
	        if (y < 0 || y + height > canvasHeight) {
	            dy = -dy; 
	       
	        }

	      
	        x += dx;
	        y += dy;

	        
	        circleBounds = new Rectangle(x, y, width, height);

	        
	        repaint();

	        try {
	            Thread.sleep(20); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private void moveBall(Graphics g) {
		Rectangle bounds = this.getBounds();
		int width = 100;
		int height = 100;
		g.setColor(color);
		Random randomizer = new Random();

		for (int i = 0; i < 50; i++) {
			int random = randomizer.nextInt() % 600;

			int x = Math.abs(random);
			random = randomizer.nextInt() % 600;
			int y = Math.abs(random);
			
			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			g.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);
			
			g.fillOval(x, y, width, height);
		}
	}
}
