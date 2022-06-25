package com.example.yujin;
import java.awt.*;
import javax.swing.*;

import com.example.yujin.LinePanel.MyMouseListener;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Line extends JMenuItem implements ActionListener{	
	//JPanel panel = MainFrame.panel;
	JPanel panel = new LinePanel();
	Point start = null, end = null; // 마우스의 시작점과 끝점
	Line(String s){
		super(s);
		createLine();
		//this.setVisible(true);
		
	}
	
	public void createLine() {
		// listener를 아래 두 리스너로 공통으로 등록해야 한다.
		panel.setBackground(Color.WHITE);
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.label.setText("/ : Draw Line");
		//panel.setSize(100,100);
		MainFrame.panel.add(panel);
        System.out.println("Line");
	}
	
}