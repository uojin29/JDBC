package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ColorButton{
	
	ColorButton(){
		createProperty();
	}
	
	public void createProperty() {
		MainFrame.button.setOpaque(true);
		MainFrame.button.setBorderPainted(false);
		MainFrame.button.setBackground(Color.BLACK);
		MainFrame.button.addActionListener(listener);
	}
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//String size = MainFrame.textfield.getText();
			if(e.getSource() == MainFrame.button) {
				ColorChooser color = new ColorChooser();
			}
		}
	};
}