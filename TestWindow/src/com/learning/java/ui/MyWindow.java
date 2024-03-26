package com.learning.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyWindow implements ActionListener {

    static final private Map<String, Color> colorMap = new HashMap<>();
    private SpinnerListModel model;
    private JFrame frame;
    private Drawing canvas;
    private String title;

    static {

        colorMap.put("Black", Color.BLACK);
        colorMap.put("Blue", Color.BLUE);
        colorMap.put("Cyan", Color.CYAN);
        colorMap.put("Gray", Color.GRAY);
        colorMap.put("Green", Color.GREEN);
        colorMap.put("Magenta", Color.MAGENTA);
        colorMap.put("Orange", Color.ORANGE);
        colorMap.put("Yellow", Color.YELLOW);
        colorMap.put("Red", Color.RED);
        colorMap.put("Pink", Color.PINK);
        colorMap.put("Dark Gray", Color.DARK_GRAY);
        colorMap.put("Light Gray", Color.LIGHT_GRAY);
    
    }
    
    public MyWindow() {
        title = "My Application Window";
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        frame.setLocation(new Point(200, 200));
        Panel mainPanel = new Panel(new BorderLayout(7, 7));
        frame.setContentPane(mainPanel);
        model = new SpinnerListModel(colorMap.keySet().toArray());
        addMenu();
		addCanvas();
		addButton("Okay");
		addSidePanel();
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        fileMenu.add(new AbstractAction("Exit") {
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        frame.setJMenuBar(menuBar);
    }
    private Color getCurrentColor() {
    	String selectedColorName = (String) model.getValue();
        Color selectedColor = colorMap.get(selectedColorName);
        return selectedColor;
    }
    
    private void addCanvas() {
    	Color background = new Color(50,40,60);
        Color selectedColor = getCurrentColor();
        canvas = new Drawing(selectedColor);
        canvas.setBounds(0, 0, 700, 700);
        canvas.setBackground(background);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
    }

    private void addButton(String text) {
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

    /**
     * Populate side panel with buttons and spinner 
     */
    private void addSidePanel() {
        
        JSpinner spinner = new JSpinner(model);
        spinner.setPreferredSize(new Dimension(100, 50));
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
            textField.setHorizontalAlignment(JTextField.CENTER);
        }
        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color selectedColor = getCurrentColor();
                canvas.setColor(selectedColor);
            }
        
        };
        spinner.addChangeListener(listener);
        JPanel panel = new JPanel(new GridLayout(5, 1, 7, 7)); 
        panel.add(spinner);
        Integer dx = Integer.valueOf(canvas.getDx());
        JTextField dxField = new JTextField(dx.toString());
        panel.add(dxField);
        // Create new action for push button to set new Dx value 
        AbstractAction action1 = new AbstractAction("Set Dx") {

			@Override
			public void actionPerformed(ActionEvent e) {
				String value = dxField.getText();
				try { 
					int dxValue = Integer.parseInt(value);
					canvas.setDx(dxValue);
				} catch(NumberFormatException ex) {
					
				}
			}
        	
        };
        JButton dxButton = new JButton(action1);
        panel.add(dxButton);
        frame.getContentPane().add(panel, BorderLayout.EAST);
        
        Integer dy = Integer.valueOf(canvas.getDy());
        JTextField dyField = new JTextField(dy.toString());
        panel.add(dyField);
        JButton dyButton = new JButton(new AbstractAction("Set Dy") {

			@Override
			public void actionPerformed(ActionEvent e) {
				String value = dyField.getText();
				try { 
					int dyValue = Integer.parseInt(value);
					canvas.setDy(dyValue);
				} catch(NumberFormatException ex) {
					
				}
			}
        	
        });
        panel.add(dyButton);
        frame.getContentPane().add(panel, BorderLayout.EAST);
    }
        
}