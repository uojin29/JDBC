package com.example.yujin;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MyEvent extends JPanel{
	Point startP=null;
	Point endP=null;
	
	ArrayList<Point> sv = new ArrayList<Point>(); // 시작
	ArrayList<Point> se = new ArrayList<Point>(); // 끝점
	
	public MyEvent(){
		MyMouseListener ml = new MyMouseListener();
		this.addMouseListener(ml); // 리스너
		this.addMouseMotionListener(ml);
		this.setBounds(0,0,1200,800);
		this.setBackground(Color.WHITE);
		MainFrame.canvasPanel.add(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // 부모 페인트호출
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(Float.parseFloat(MainFrame.textfield.getText())));
		g2.setColor(ColorChooser.color);
		if(sv.size() != 0){
			for(int i=0;i<se.size();i++){ //벡터크기만큼
				Point sp = sv.get(i); // 벡터값을꺼내다
				Point ep = se.get(i);
				
				if(MainFrame.toolName.equals("Line")) {
					g.drawLine(sp.x, sp.y, ep.x, ep.y);//그리다
					//System.out.println("MouseListener Line 작동 ");
				}
				else if(MainFrame.toolName.equals("Circle")) {
					g.drawOval(Math.min(sp.x, ep.x), Math.min(sp.y, ep.y),Math.abs(ep.x- sp.x),Math.abs(ep.y- sp.y));
				}
				else if(MainFrame.toolName.equals("Square")) {
					g.drawRect(Math.min(sp.x, ep.x), Math.min(sp.y, ep.y),Math.abs(ep.x- sp.x),Math.abs(ep.y- sp.y));
				}
				
			}
		}
		if(startP != null) {
			if(MainFrame.toolName.equals("Line")) {
				g.drawLine(startP.x, startP.y, endP.x, endP.y);	//그리다
				//System.out.println("MouseListener Line 작동 ");
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
			sv.add(e.getPoint()); // 클릭한부분을 시작점으로
		}
		public void mouseReleased(MouseEvent e){
			se.add(e.getPoint()); // 드래그 한부분을 종료점으로
			endP = e.getPoint();
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
