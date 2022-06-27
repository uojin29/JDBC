package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Add extends JMenu{
	JMenuItem add_eraser = new JMenuItem("Eraser");
	JMenuItem add_undo = new JMenuItem("Undo");
	JMenuItem add_redo = new JMenuItem("Redo");
	JMenuItem text = new JMenuItem("Text");
	
	Add(String s){
		super(s);
		createProperty();
	}
	
	public void createProperty() {
		this.add(add_eraser);
		this.add(add_undo);
		this.add(add_redo);
		this.add(text);
		
		add_eraser.addActionListener(listener);
		add_undo.addActionListener(listener);
		add_redo.addActionListener(listener);
		text.addActionListener(listener);
}
	
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String tool = e.getActionCommand();
			if(tool.equals("Eraser")) {
				MainFrame.toolName = "Eraser";
				MainFrame.label.setText("[Eraser]");
			}
			else if(tool.equals("Undo")) {
				MainFrame.label.setText("[Undo]");
				if(MyEvent.list.size() != 0){
					MyEvent.stack.push(MyEvent.list.get(MyEvent.list.size() - 1));
					MyEvent.list.remove(MyEvent.list.size() - 1);
			        MyEvent.startP = null;
			        MyEvent.endP = null;
			        MainFrame.canvasPanel.repaint();
	    		}
			}
			else if(tool.equals("Redo")) {
				MainFrame.label.setText("[Redo]");
				if(MyEvent.stack.size() != 0){
					MyEvent.list.add(MyEvent.stack.pop());
					MyEvent.startP = null;
					MyEvent.endP = null;
					MainFrame.canvasPanel.repaint();
		        }
			}
			else if(tool.equals("Text")) {//확인함 
				MainFrame.toolName = "Text";
				MainFrame.label.setText("[Text]");
				//System.out.println(MainFrame.toolName);
			}
		}
	};
	
}