package com.example.yujin;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.colorchooser.ColorSelectionModel;

public class ColorChooser extends JFrame implements ChangeListener{
   static boolean colorChange;
   private Color color = Color.BLACK;
   
   @Override
   public void stateChanged(ChangeEvent e) {
      MainFrame.colorValue = color;
      colorChange = true;
   }
   
   public ColorChooser(){
      setTitle("색상 고르기");
      setLocation(400, 200);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      pack();
      
   }
   public Color getColor() {
	   return color;
   }
}