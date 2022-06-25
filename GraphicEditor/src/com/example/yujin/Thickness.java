package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Thickness extends JMenuItem implements ActionListener{
	JPanel thick = new JPanel();
	int size = 0;
	Thickness(String s){
		super(s);
		createThickness();
		thick.setLayout(new FlowLayout());
	}
	public void createThickness() {		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.label.setText("Mode: Choose Thickness");
		System.out.println("thick");
		//makeButton();
		
	}

}
