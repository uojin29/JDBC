package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StartPage extends JFrame{
	public Login login = null;
	public SignUp signup = null;
	static final int WIDTH = 1200;
	static final int HEIGHT = 800;

	public void change(String panelName) {
		if(panelName.equals("SignUp")) {
			getContentPane().removeAll();
			getContentPane().add(signup);
			revalidate();
			repaint();
		}
		else if(panelName.equals("Login")){
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}
	}
	public static void main(String [] args) {
		StartPage start = new StartPage();
		
		start.signup = new SignUp(start);
		start.login = new Login(start);
		
		start.add(start.signup);
		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		start.setSize(WIDTH, HEIGHT);
		start.setVisible(true);
	}
}
