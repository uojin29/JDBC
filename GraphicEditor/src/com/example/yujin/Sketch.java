package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Sketch extends JMenu{
	Line line = new Line("Line");
	Square square = new Square("Square");
	Circle circle = new Circle("Circle");
	Free_Sketch free_sketch = new Free_Sketch("Free_Sketch");
	
	Sketch(String s){
		super(s);
		createSketch();
		
	}
	//JMenuItem line = new JMenuItem("Line");
	public void createSketch() {
		this.add(line);
		this.add(square);
		this.add(circle);
		this.add(free_sketch);
	}
}