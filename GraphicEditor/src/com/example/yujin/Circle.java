package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;

public class Circle extends JMenuItem implements ActionListener{
	JPanel panel = new CirclePanel();
	Circle(String s){
		super(s);
		createCircle();
	}
	
	public void createCircle() {
		addActionListener(this);
		//MainFrame.panel = this.panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//this.panel = MainFrame.panel;
		//
		//MainFrame.panel = new CirclePanel();
		MainFrame.panel.add(panel);
		MainFrame.label.setText("Mode: Draw Circle");
		System.out.println("Circle");
		
	}
}
