package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MenuBar extends JMenuBar{
	Sketch sketch = new Sketch("Sketch");
	Property property = new Property("Property");
	Add add = new Add("Add");
	
	public MenuBar(){
		createMenus();
	}
	
	public void createMenus() {
		this.add(sketch);
		this.add(property);
		this.add(add);
	}
}
