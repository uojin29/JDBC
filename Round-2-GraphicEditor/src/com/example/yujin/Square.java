package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Square extends JMenuItem implements ActionListener{	
	JPanel panel = new SquarePanel();
	Square(String s){
		super(s);
		createSquare();
	}
	
	public void createSquare() {
		addActionListener(this);
		panel.setBackground(Color.WHITE);
		//MainFrame.panel = this.panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//MainFrame.panel = new JPanel();
		MainFrame.panel.add(panel);
		MainFrame.label.setText("Mode: Draw Square");
		System.out.println("Square");
		
	}
}
