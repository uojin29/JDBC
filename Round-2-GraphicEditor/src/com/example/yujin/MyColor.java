package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyColor extends JMenuItem implements ActionListener{
	
	MyColor(String s){
		super(s);
		createColor();
	}
	public void createColor() {
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.label.setText("Mode: Choose Color");

		System.out.println("color");
		
	}
}
