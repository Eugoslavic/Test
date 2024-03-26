package com.learning.java.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Drawing extends Canvas {
	private Color color;
	
    private int dx = 12; 
    public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	private int dy = 8; 
	
	private Rectangle circleBounds = new Rectangle(0,0,100,100);

	public Drawing(Color color) {
		this.color = color;
		Runnable runable = new Runnable() {

			@Override
			public void run() {
				moveBall();
				
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

	private void moveBall() {
	    int canvasWidth = getWidth();
	    int canvasHeight = getHeight();
	    int width = circleBounds.width;
	    int height = circleBounds.height;

	    int x = circleBounds.x + 36;
	    int y = circleBounds.y + 72;

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
}
