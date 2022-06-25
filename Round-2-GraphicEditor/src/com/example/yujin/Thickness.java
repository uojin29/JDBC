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
//	public void makeButton() {
//		JLabel thickness = new JLabel("굵기 조절: ");
//		JTextField thicktext = new JTextField(5);
//		thick.add(thickness);
//		thick.add(thicktext);
//		String text = thicktext.getText();
//		size = Integer.parseInt(text);
//		//thick.setBounds(100, 100, 50, 50);
//		MainFrame.panel.add(thick);
//		MainFrame.panel.add(thickness);
//		MainFrame.panel.add(thicktext);
		
//	}
//	public void paintComponent(Graphics g) {
//		 Graphics2D g2 = (Graphics2D)g;
//		 g2.setStroke(new BasicStroke(size,BasicStroke.CAP_ROUND,0));
//	}
}
