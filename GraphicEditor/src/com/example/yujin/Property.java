package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Property extends JMenu{
	JMenuItem thickness = new JMenuItem("Thickness");
	JMenuItem mycolor = new JMenuItem("Color");
	
	Property(String s){
		super(s);
		createProperty();
	}
	
	public void createProperty() {
		this.add(thickness);
		this.add(mycolor);
		
		thickness.addActionListener(listener);
		mycolor.addActionListener(listener);
	}
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String tool = e.getActionCommand();
			if(tool.equals("Thickness")) {
				MainFrame.toolName = "Thickness";
			}
			else if(tool.equals("Color")) {
				MainFrame.toolName = "Color";
				ColorChooser color = new ColorChooser();
			}
		}
	};
}