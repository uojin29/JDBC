package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Drag extends JMenuItem implements ActionListener{
	
	Drag(String s){
		super(s);
		createDrag();
	}
	public void createDrag() {
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.label.setText("Mode: Drag");
		System.out.println("Drag");
		
	}
}
