package com.example.yujin;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class MenuBar extends JMenuBar{
	Sketch sketch = new Sketch("Sketch");//Sketch라는 클래스를 호출하여 "Sketch"라는 이름으로 인스턴스화 함 
	Property property = new Property("Property");//Property라는 클래스를 호출하여 "Property"라는 이름으로 인스턴스화 함 
	Add add = new Add("Add");//Add라는 클래스를 호출하여 "Add"라는 이름으로 인스턴스화 함 
	
	public MenuBar(){
		createMenus();
	}
	
	public void createMenus() {//3가지 메뉴아이템을 이 메뉴바에 붙임 
		this.add(sketch);
		this.add(property);
		this.add(add);
	}
}