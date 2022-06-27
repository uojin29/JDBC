package com.example.yujin;
import java.awt.*;
import javax.swing.*;

import com.example.yujin.MyEvent.List;

import java.awt.event.*;
import java.util.*;

public class Add extends JMenu{
	JMenuItem add_eraser = new JMenuItem("Eraser");
	JMenuItem add_undo = new JMenuItem("Undo");
	JMenuItem add_redo = new JMenuItem("Redo");
	
	Add(String s){
		super(s);
		createProperty();
	}
	
	public void createProperty() {
		this.add(add_eraser);
		this.add(add_undo);
		this.add(add_redo);
		
		add_eraser.addActionListener(listener);
		add_undo.addActionListener(listener);
		add_redo.addActionListener(listener);
	}
	
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String tool = e.getActionCommand();
			if(tool.equals("Eraser")) {
				MainFrame.toolName = "Eraser";
				MainFrame.label.setText("[Eraser]");
			}
			else if(tool.equals("Undo")) {
				//MainFrame.toolName = "Undo";
				MainFrame.label.setText("[Undo]");
			if(MyEvent.list.size() != 0){
		          //List a = MyEvent.list.remove(MyEvent.list.size() - 1);
		          //MyEvent.stack.push(a);
				MyEvent.stack.push(MyEvent.list.get(MyEvent.list.size() - 1));
				MyEvent.list.remove(MyEvent.list.size() - 1);
		          //System.out.println("undo" + MyEvent.stack);
		          MyEvent.startP = null;
		          MyEvent.endP = null;
		          MainFrame.canvasPanel.repaint();
	           }
			}
			else if(tool.equals("Redo")) {
				MainFrame.label.setText("[Redo]");
		       if(MyEvent.stack.size() != 0){
		         // List b = MyEvent.stack.pop();
		         // MyEvent.list.add(b);
		    	   MyEvent.list.add(MyEvent.stack.pop());
		          System.out.println("redo" + MyEvent.stack);  
		          MyEvent.startP = null;
		          MyEvent.endP = null;
		           
		           MainFrame.canvasPanel.repaint();
		        }
			}
		}
	};
	
}