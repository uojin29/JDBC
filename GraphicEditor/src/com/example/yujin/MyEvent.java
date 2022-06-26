package com.example.yujin;
import java.awt.*;
import java.util.*;
import javax.swing.*;

import com.example.yujin.List;

import java.awt.event.*;
import java.util.*;

public class MyEvent extends JPanel{
	Point startP=null;
	Point endP=null;
	ArrayList<List> list = new ArrayList<List>();
//	
	
	
	
	public MyEvent(){
		MyMouseListener ml = new MyMouseListener();
		this.addMouseListener(ml); // 리스너
		this.addMouseMotionListener(ml);
		this.setBounds(0,0,1200,800);
		this.setBackground(Color.WHITE);
		MainFrame.canvasPanel.add(this);
	}
	
	class List {
		String drawType;
		Color colorList;
		float thicknessList;
		Point sv;
		Point se;
		
		List(String drawType, Color colorList, float thicknessList, Point sv, Point se){
			this.drawType = drawType;
			this.colorList = colorList;
			this.thicknessList = thicknessList;
			this.sv = sv;
			this.se = se;
		}
		List(Point sv, Point se){
			this.sv = sv;
			this.se = se;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // 부모 페인트호출
		Graphics2D g2=(Graphics2D)g;
		
		if(list.size() != 0){
			for(int i = 0; i < list.size();i++){ //벡터크기만큼
				List e = list.get(i);
				g2.setStroke(new BasicStroke(e.thicknessList));//굵기 조절 바로 하기 
				g2.setColor(e.colorList);//색 조절하기 
				if(e.drawType.equals("Line")) {
					g.drawLine(e.sv.x, e.sv.y, e.se.x, e.se.y);//그리다
					//System.out.println("MouseListener Line 작동 ");
				}
				else if(e.drawType.equals("Circle")) {
					g.drawOval(Math.min(e.sv.x, e.se.x), Math.min(e.sv.y, e.se.y),Math.abs(e.se.x- e.sv.x),Math.abs(e.se.y- e.sv.y));
				}
				else if(e.drawType.equals("Square")) {
					g.drawRect(Math.min(e.sv.x, e.se.x), Math.min(e.sv.y, e.se.y),Math.abs(e.se.x- e.sv.x),Math.abs(e.se.y- e.sv.y));
				}
			}
		}
		if(startP != null) {
			g2.setStroke(new BasicStroke(Float.parseFloat(MainFrame.textfield.getText())));//굵기 조절 바로 하기 
			g2.setColor(ColorChooser.color);//색 조절하기 
			if(MainFrame.toolName.equals("Line")) {
				g.drawLine(startP.x, startP.y, endP.x, endP.y);	//그리다
			}
			else if(MainFrame.toolName.equals("Circle")) {
				g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
				//System.out.println("MouseListener Circle 작동 ");
			}
			else if(MainFrame.toolName.equals("Square")) {
				g.drawRect(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
				//System.out.println("MouseListener Square 작동 ");
			}
		}
	}
	
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
		public void mousePressed(MouseEvent e){
			startP = e.getPoint();
			
		}
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint();
			new List(startP, endP);
			//elements.add(new Element(shape, c, MainFrame.count, startP, endP, vStart));
			list.add(new List(MainFrame.toolName, ColorChooser.color, Float.parseFloat(MainFrame.textfield.getText()), startP, endP));
			repaint(); // 다시그려라
		}
		
		public void mouseDragged(MouseEvent e){
			endP = e.getPoint();
			repaint();
		}
		
		public void mouseMoved(MouseEvent e){
			
		}
	}
	
}
