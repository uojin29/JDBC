package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Property extends JMenu{
	JMenuItem thickness = new JMenuItem("Thickness");
	
	Property(String s){
		super(s);
		createProperty();
	}
	
	public void createProperty() {
		this.add(thickness);
		
		MainFrame.button.addActionListener(listener);
		//MainFrame.textfield.addActionListener(listener);
	}
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//String tool = e.getActionCommand();
			String size = MainFrame.textfield.getText();
			if(e.getSource() == MainFrame.button) {
				ColorChooser color = new ColorChooser();
			}
		}
	};
}