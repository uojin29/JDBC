package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Add extends JMenu{
	JMenuItem add_eraser = new JMenuItem("Eraser");
	//JMenuItem add_drag = new JMenuItem("Drag");
	JMenuItem add_undo = new JMenuItem("Undo");
	JMenuItem add_redo = new JMenuItem("Redo");
	
	Add(String s){
		super(s);
		createProperty();
	}
	
	public void createProperty() {
		this.add(add_eraser);
		this.add(add_undo);
		this.add(add_redo);
		//this.add(add_drag);
		
		add_eraser.addActionListener(listener);
		//add_drag.addActionListener(listener);
		add_undo.addActionListener(listener);
		add_redo.addActionListener(listener);
	}
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String tool = e.getActionCommand();
			if(tool.equals("Eraser")) {
				MainFrame.toolName = "Eraser";
				MainFrame.label.setText("[Eraser]");
				System.out.println("ActionListener Eraser 작동 ");
			}
//			else if(tool.equals("Drag")) {
//				MainFrame.toolName = "Drag";
//				MainFrame.label.setText("[Drag]");
//				System.out.println("ActionListener Drag 작동 ");
//			}
			else if(tool.equals("Undo")) {
				MainFrame.toolName = "Undo";
				MainFrame.label.setText("[Undo]");
				System.out.println("Undo 작동 ");
			}
			else if(tool.equals("Redo")) {
				MainFrame.toolName = "Redo";
				MainFrame.label.setText("[Redo]");
				System.out.println("Redo 작동 ");
			}
		}
	};
}