package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Property extends JMenu{
	Thickness thickness = new Thickness("Thickness");
	MyColor mycolor = new MyColor("Color");
	public JMenu propertyMenu;
	Property(String s){
		super(s);
		createProperty();
	}
	
	public void createProperty() {
		this.add(thickness);
		this.add(mycolor);
	}
}