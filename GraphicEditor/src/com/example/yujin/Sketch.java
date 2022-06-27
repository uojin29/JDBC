package com.example.yujin;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Sketch extends JMenu{
	JMenuItem pen = new JMenuItem("Pen");
	JMenuItem line = new JMenuItem("Line");
	JMenuItem square = new JMenuItem("Square");
	JMenuItem circle = new JMenuItem("Circle");
	
	Sketch(String s){
		super(s);
		createSketch();
	}
	public void createSketch() {
		this.add(pen);
		this.add(line);
		this.add(square);
		this.add(circle);
		
		pen.addActionListener(listener);
		line.addActionListener(listener);
		square.addActionListener(listener);
		circle.addActionListener(listener);
	}
	
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String tool = e.getActionCommand();
			if(tool.equals("Pen")) {
				MainFrame.toolName = "Pen";
				MainFrame.label.setText("[Pen]");
			}
			else if(tool.equals("Line")) {
				MainFrame.toolName = "Line";
				MainFrame.label.setText("[Line]");
			}
			else if(tool.equals("Square")) {
				MainFrame.toolName = "Square";
				MainFrame.label.setText("[Square]");
			}
			else if(tool.equals("Circle")) {
				MainFrame.toolName = "Circle";
				MainFrame.label.setText("[Circle]");
			}
		}
	};
}