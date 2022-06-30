package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class DataBase_main extends JFrame{
	static JFrame start = new JFrame();
	static String userid;
	DataBase_main(){
		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		start.setSize(1200, 800);
		start.setVisible(true);
	}
	public static void main(String [] args) {
		StartPage startPage = new StartPage();
		DataBase_main mainFrame = new DataBase_main();
	}
}
