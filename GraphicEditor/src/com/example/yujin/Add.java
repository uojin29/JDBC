package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Add extends JMenu{
	JMenuItem add_eraser = new JMenuItem("Eraser");
	JMenuItem add_drag = new JMenuItem("Drag");
	
	Add(String s){
		super(s);
		createProperty();
	}
	
	public void createProperty() {
		this.add(add_eraser);
		this.add(add_drag);
		
		add_eraser.addActionListener(listener);
		add_drag.addActionListener(listener);
	}
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String tool = e.getActionCommand();
			if(tool.equals("Eraser")) {
				MainFrame.toolName = "Eraser";
				System.out.println("ActionListener Eraser 작동 ");
			}
			else if(tool.equals("Drag")) {
				MainFrame.toolName = "Drag";
				System.out.println("ActionListener Drag 작동 ");
			}
		}
	};
}