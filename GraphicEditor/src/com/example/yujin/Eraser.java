package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Eraser extends JMenuItem implements ActionListener{
	
	Eraser(String s){
		super(s);
		createEraser();
	}
	public void createEraser() {
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.label.setText("Mode: Eraser");
		System.out.println("eraser");
		
	}
}
