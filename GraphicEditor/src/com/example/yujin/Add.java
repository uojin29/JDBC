package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Add extends JMenu{
	public JMenu addMenu;
	Eraser add_eraser = new Eraser("Eraser");
	Drag add_drag = new Drag("Drag");
	
	Add(String s){
		super(s);
		createAdd();
	}
	
	public void createAdd() {
		this.add(add_eraser);
		this.add(add_drag);
	}
}