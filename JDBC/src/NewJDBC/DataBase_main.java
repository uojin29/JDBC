package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class DataBase_main extends JFrame{
	public StartPage startPage = null;
	public Login login = null;
	public SignUp signUp = null;
	public SearchId searchID = null;
	public Completion complete = null;
	//public User user = null;

	public void change(String panelName) {
		if(panelName.equals("SignUp")) {
			getContentPane().removeAll();
			getContentPane().add(signUp);
			revalidate();
			repaint();
		}
		else if(panelName.equals("Login")){
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}
		else if(panelName.equals("Search ID/PW")){
			getContentPane().removeAll();
			getContentPane().add(searchID);
			revalidate();
			repaint();
		}
		else if(panelName.equals("Completion")){
			getContentPane().removeAll();
			getContentPane().add(complete);
			revalidate();
			repaint();
		}
			//else if(panelName.equals("User")){
//			getContentPane().removeAll();
//			getContentPane().add(user);
//			revalidate();
//			repaint();
//		}
		else {
			getContentPane().removeAll();
			getContentPane().add(startPage);
			revalidate();
			repaint();
		}
	}
	public static void main(String [] args) {
		DataBase_main start = new DataBase_main();
		start.signUp = new SignUp(start);
		start.login = new Login(start);
		start.startPage = new StartPage(start);
		start.searchID = new SearchId(start);
		start.signUp = new SignUp(start);
		start.complete = new Completion(start);
	//	start.user = new User(start);
		
		start.add(start.startPage);
		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		start.setSize(1200, 800);
		start.setVisible(true);
	}
}
