package com.learning.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyWindow implements ActionListener {

	static private Color[] colors = new Color[] { Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN,
			Color.MAGENTA, Color.ORANGE, Color.YELLOW, Color.RED, Color.PINK, Color.DARK_GRAY, Color.LIGHT_GRAY };

	private JFrame frame;

	private Drawing canvas;

	private String title;

	public MyWindow() {

		title = "My Application Window";
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800, 800));
		frame.setLocation(new Point(200, 200));
		Panel mainPanel = new Panel(new BorderLayout(7, 7));
		frame.setContentPane(mainPanel);

		addMenu();

	}

	public void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        fileMenu.add(new AbstractAction("Exit") {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
				
			}
        		
        });
        
        frame.setJMenuBar(menuBar);

    }

	public void addCanvas() {
		canvas = new Drawing(Color.black);
		canvas.setBounds(0, 0, 700, 700);
		canvas.setBackground(Color.pink);
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
	}

	public void addButton(String text) {
		JButton button = new JButton(text);
		button.setPreferredSize(new Dimension(100, 100));

		frame.getContentPane().add(button, BorderLayout.SOUTH);

		ActionListener handler = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		};
		button.addActionListener(handler);
	}

	public void open() {
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}

	public void close() {
		frame.dispose();
	}

	public void addSpinner() {
		final SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 11, 1);
		JSpinner spinner = new JSpinner(model);
		spinner.setPreferredSize(new Dimension(50, 50));
		ChangeListener listener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Number n = model.getNumber();
				Color aColor = colors[n.intValue()];
				canvas.setColor(aColor);
			}
		};
		spinner.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(spinner);
		frame.getContentPane().add(panel, BorderLayout.EAST);
	}
}