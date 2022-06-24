package com.example.yujin;
import java.awt.*;
import javax.swing.*;

import com.example.yujin.Menu;

import java.awt.event.*;
import java.util.*;

public class MainFrame{
	public static JFrame frame = new JFrame();
	Menu menu = new Menu();

	public MainFrame() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel();

		frame.setTitle("Graphic Editor");
		frame.setSize(800,800);
		frame.setResizable(false);
		
		
		panel.add(new JLabel("출력 확인용 label"));
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
		//Screen screen = new Screen();
		//Button button = new Button();
		//screen.setScreen();
		//screen.setScreen();
		//menu.setMenu();
		System.out.println("Main 출력 확인 ");
	}
}
