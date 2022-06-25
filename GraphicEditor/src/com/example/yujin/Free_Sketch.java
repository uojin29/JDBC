package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;

public class Free_Sketch extends JMenuItem implements ActionListener{	
	Free_Sketch(String s){
		super(s);
		createFree();
	}
	
	public void createFree() {
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.label.setText("Mode: Draw Free line");
		System.out.println("free");		
	}
}
