package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import com.example.yujin.LinePanel.MyMouseListener;
import java.awt.event.*;
import java.util.*;

public class MainFrame extends JFrame{
	public static JPanel panel = new JPanel();
	public static JLabel label = new JLabel("Default!",JLabel.LEFT);
	JPanel menu = new JPanel();
	//JPanel mode = new JPanel();
	Point start = null, end = null;
	//MainPanel panel = new MainPanel();
	//LinePanel panel = new LinePanel();
	//CirclePanel panel = new CirclePanel(); 
	//SquarePanel panel = new SquarePanel();
	
	public MainFrame() {
		this.setTitle("Graphic Editor");
		panel.setLayout(new FlowLayout());
	}
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.createMainFrame();
	}
	
	private void createMainFrame() {
		MenuBar menubar = new MenuBar();
		panel.setBackground(Color.WHITE);
		this.add(menubar);
		this.setJMenuBar(menubar);
		this.setSize(800,800);
		this.setResizable(false);
		//mode.add(label);
		menu.add(label);
		panel.setLayout(new BorderLayout());
		//panel.add(label);
		//panel.add(menu);
		this.add(menu, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
