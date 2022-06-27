package com.example.yujin;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class MyEvent extends JPanel{
	static Point startP = null;
	static Point endP = null;
	static ArrayList<List> list = new ArrayList<List>();
	ArrayList<Point> p;
	static Stack <List> stack = new Stack<List>();
	ArrayList<String> s = new ArrayList<String>();
	
	public MyEvent(){
		MyMouseListener ml = new MyMouseListener();
		this.addMouseListener(ml); // 리스너
		this.addMouseMotionListener(ml);
		this.setBounds(0,0,1200,800);
		this.setBackground(Color.WHITE);
	}
	class List {
		String drawType;
		Color colorList;
		float thicknessList;
		Point sv;
		Point se;
		
		ArrayList<Point> point = new ArrayList<Point>();//점들의 집합  
		
		List(String drawType, Color colorList, float thicknessList, Point sv, Point se){
			this.drawType = drawType;
			this.colorList = colorList;
			this.thicknessList = thicknessList;
			this.sv = sv;
			this.se = se;
			this.point = null;
		}
		List(String drawType, Color colorList, float thicknessList, Point sv, Point se, ArrayList<Point> point){
			this.drawType = drawType;
			this.colorList = colorList;
			this.thicknessList = thicknessList;
			this.sv = sv;
			this.se = se;
			for(int i = 0; i < point.size(); i++) {
				this.point = point;
			}
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // 부모 페인트호출
		Graphics2D g2=(Graphics2D)g;
		if(list.size() != 0){
			for(int i = 0; i < list.size();i++){ //벡터크기만큼
				List e = list.get(i);
				g2.setStroke(new BasicStroke(e.thicknessList,BasicStroke.CAP_ROUND,0));//굵기 조절 바로 하기 
				if(e.drawType.equals("Line")) {
					g2.setColor(e.colorList);//색 조절하기 
					g.drawLine(e.sv.x, e.sv.y, e.se.x, e.se.y);//그리다
				}
				else if(e.drawType.equals("Square")) {
					g2.setColor(e.colorList);//색 조절하기 
					g.drawRect(Math.min(e.sv.x, e.se.x), Math.min(e.sv.y, e.se.y),Math.abs(e.se.x- e.sv.x),Math.abs(e.se.y- e.sv.y));
				}
				else if(e.drawType.equals("Circle")) {
					g2.setColor(e.colorList);//색 조절하기 
					g.drawOval(Math.min(e.sv.x, e.se.x), Math.min(e.sv.y, e.se.y),Math.abs(e.se.x- e.sv.x),Math.abs(e.se.y- e.sv.y));
				}
				else if(e.drawType.equals("Pen")) {
					g2.setColor(e.colorList);//색 조절하기 
					for(int j = 0; j < e.point.size() - 1; j++) {
						g.drawLine(e.point.get(j).x, e.point.get(j).y, e.point.get(j + 1).x, e.point.get(j + 1).y);
					}
				}
				else if(e.drawType.equals("Eraser")) {
					g2.setColor(Color.WHITE);//색 조절하기 
					for(int j = 0; j < e.point.size() - 1; j++) {
						g.drawLine(e.point.get(j).x, e.point.get(j).y, e.point.get(j + 1).x, e.point.get(j + 1).y);
					}
				}
				else if(e.drawType.equals("Text")) {
					g2.setFont(new Font("", Font.PLAIN, (int)e.thicknessList));
					g2.setColor(e.colorList);
					for(int j = 0; j < e.point.size() - 1; j++) {
						g.drawString(s.get(i), e.sv.x, e.sv.y);
					}
				}
			}
		}
		
		if(startP != null) {
			g2.setStroke(new BasicStroke(Float.parseFloat(MainFrame.textfield.getText()),BasicStroke.CAP_ROUND,0));//굵기 조절 바로 하기 
			
			if(MainFrame.toolName.equals("Line")) {
				g2.setColor(MainFrame.colorValue);//색 조절하기 
				g.drawLine(startP.x, startP.y, endP.x, endP.y);	//그리다
			}
			else if(MainFrame.toolName.equals("Square")) {
				g2.setColor(MainFrame.colorValue);//색 조절하기 
				g.drawRect(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
			}
			else if(MainFrame.toolName.equals("Circle")) {
				g2.setColor(MainFrame.colorValue);//색 조절하기 
				g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
			}
			else if(MainFrame.toolName.equals("Pen")) {
				for(int i = 0; i < p.size() - 1; i++) {
					g2.setColor(MainFrame.colorValue);//색 조절하기 
					g.drawLine(p.get(i).x, p.get(i).y, p.get(i + 1).x, p.get(i + 1).y);
				}
			}
			else if(MainFrame.toolName.equals("Eraser")) {
				g2.setColor(Color.WHITE);//색 조절하기 
				for(int i = 0; i < p.size() - 1; i++) {
					g.drawLine(p.get(i).x, p.get(i).y, p.get(i + 1).x, p.get(i + 1).y);
				}
			}
		}
	}
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
		public void mousePressed(MouseEvent e){
			startP = e.getPoint();
			p = new ArrayList<Point>();
			p.add(startP);
			s.add(MainFrame.inputText.getText());
			if(MainFrame.toolName.equals("Eraser")) {
				repaint();
			}
		}
		
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint();
			p.add(endP);
			if(MainFrame.toolName.equals("Line") || MainFrame.toolName.equals("Square") || MainFrame.toolName.equals("Circle")) {
				list.add(new List(MainFrame.toolName, MainFrame.colorValue, Float.parseFloat(MainFrame.textfield.getText()), startP, endP));
			}
			else if(MainFrame.toolName.equals("Pen")) {
				list.add(new List(MainFrame.toolName, MainFrame.colorValue, Float.parseFloat(MainFrame.textfield.getText()), startP, endP, p));
			}
			else if(MainFrame.toolName.equals("Eraser")) {
				list.add(new List(MainFrame.toolName, MainFrame.colorValue, Float.parseFloat(MainFrame.textfield.getText()), startP, endP, p));
			}
			else if(MainFrame.toolName.equals("Text")) {
				list.add(new List(MainFrame.toolName, MainFrame.colorValue, Float.parseFloat(MainFrame.textfield.getText()), startP, endP, p));
			}
			repaint();
		}
		
		public void mouseDragged(MouseEvent e){
			endP = e.getPoint();
			p.add(endP);
			repaint();
		}
		@Override
		public void mouseMoved(MouseEvent e){
			
		}
	}
	
}

