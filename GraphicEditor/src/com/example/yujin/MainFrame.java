package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MainFrame extends JFrame{
	JPanel mainPanel = new JPanel();//가장 큰 패널로 JFrame의 모든 것들을 수용하는 패널 
	JPanel status = new JPanel(); // 레이블과 버튼을 붙일 패널 
	public static JPanel canvasPanel; // 그림을 그릴 패널 
	JLabel current_tool = new JLabel("Tool : ");
	public static JLabel label = new JLabel("[Pen]"); //현재 툴의 상태를 표시해줄 레이블 
	JLabel current_color = new JLabel("		Color : ");
	JLabel current_thickness = new JLabel(" 	Thickness : ");
	public static JTextField textfield = new JTextField(5);//굵기를 조절할 수 있는 textfield
	public static String toolName = "Pen";
	public static Color colorValue = Color.BLACK;
	
	
	public MainFrame() {
		this.setTitle("Graphic Editor"); //frame의 이름 설정 
		mainPanel.setLayout(new BorderLayout()); // 가장 큰 패널을 borderlayout으로 선언
		//canvasPanel.setBackground(Color.WHITE);
		//canvasPanel.setLayout(null);
		//canvasPanel.setBounds(0,0,1200,800);
		status.setLayout(new FlowLayout(FlowLayout.LEFT));//status 패널을 플로우 레이아웃으로 선언 (왼쪽부터 차례대로 배치)
		textfield.setText("1");//굵기의 초기값을 1로 지정함 
	}
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame(); // mainframe 인스턴스화 하기 
		mainFrame.createMainFrame(); // createMainFrame 메소드를 호출 
		//mainFrame.labelSet();
	}
	
	private void createMainFrame() {
		MenuBar menubar = new MenuBar(); //menubar라는 이름으로 menubar 클래스를 호출하여 인스턴스화 함 
		canvasPanel = new MyEvent();
		ColorButton chooserCaller = new ColorButton();
		
		this.add(menubar); // 이 프레임에 메뉴바를 붙임 
		this.setJMenuBar(menubar);
		this.setSize(1200,800);//프레임 사이즈 고정 
		this.setResizable(false);//프레임 사이즈 변경 불가 
		chooserCaller.createProperty();
		status.add(current_tool);
		status.add(label);//status 패널에 label 붙임 
		status.add(current_color);
		status.add(chooserCaller);//status 패널에 button 붙임 
		status.add(current_thickness);
		status.add(textfield);
		mainPanel.add(status, BorderLayout.NORTH); //status 레이블을 mainPanel 위쪽에 붙임 
		mainPanel.add(canvasPanel, BorderLayout.CENTER);// canvas를 mainpanel 중앙에 붙임 
		this.add(mainPanel);//mainPanel을 프레임에 붙임 
		
		this.setVisible(true);
	}
//	private void labelSet() {
//		Font font = new Font("", Font.PLAIN, 15);
//		current_tool.setFont(font);
//	}
}
