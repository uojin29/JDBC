package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.util.*;

public class ColorButton extends JButton implements ChangeListener{
	ColorChooser colorChooserFrame;
	JColorChooser colorChooser;
	
	private boolean isChanged = false;
	Color color;
	ColorButton(){
		
	}
	
	public void createProperty() {
		colorChooserFrame = new ColorChooser();
		colorChooserFrame.setBounds(300, 150, 800, 600);;
		colorChooser = new JColorChooser();
		colorChooserFrame.add(colorChooser);
		colorChooser.getSelectionModel().addChangeListener(this);
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.setBackground(Color.BLACK);
		this.addActionListener(listener);
		this.setFocusPainted(false);
		if(isChanged) {
			this.setBackground(color);
			isChanged = false;
		}
	}
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			colorChooserFrame.setVisible(true);
			isChanged= true;
			ColorButton.this.setBorderPainted(false);
			ColorButton.this.setOpaque(true);
			System.out.println(color);
		}
	};
	public Color getColor() {
		return color;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		color = colorChooser.getColor();
		MainFrame.colorValue = color;
		ColorButton.this.setBackground(color);
	}
	
}