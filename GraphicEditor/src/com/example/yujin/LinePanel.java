package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class LinePanel extends JPanel{
	Point start = null, end = null; // 마우스의 시작점과 끝점
	ArrayList<Point> sv = new ArrayList<Point>(); // 시작
	ArrayList<Point> se = new ArrayList<Point>(); // 끝점
	
	public LinePanel() {
		MyMouseListener listener = new MyMouseListener();
		// listener를 아래 두 리스너로 공통으로 등록해야 한다.
		addMouseListener(listener);
		addMouseMotionListener(listener);
		MainFrame.panel.setBackground(Color.WHITE);
	}
	class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			start = e.getPoint();
			sv.add(e.getPoint());
		}
		public void mouseReleased(MouseEvent e){
			se.add(e.getPoint()); // 드래그 한부분을 종료점으로
			end = e.getPoint();
			repaint(); // 다시그려라
		}
		public void mouseDragged(MouseEvent e) {
			end = e.getPoint();
			repaint(); // 패널의 그리기 요청 주목
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(sv.size() != 0){
			for(int i=0;i<se.size();i++){ //벡터크기만큼
				Point sp = sv.get(i); // 벡터값을꺼내다
				Point ep = se.get(i);	
				g.drawLine(sp.x, sp.y, ep.x, ep.y);//그리다
			}
		}
		if(start != null)
			g.drawLine(start.x, start.y, end.x, end.y);
	}
}
