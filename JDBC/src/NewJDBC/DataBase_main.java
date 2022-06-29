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
	
//	public StartPage startPage = null;
//	public Login login = null;
//	public SignUp signUp = null;
//	public SearchId searchID = null;
//	public Completion complete = null;
	
//	public void createMain() {
//		this.add(startPage);
//		this.add(login);
//	}

//	public void change(String panelName) {
//		if(panelName.equals("SignUp")) {
//			getContentPane().removeAll();
//			getContentPane().add(signUp);
//			revalidate();
//			repaint();
//		}
//		else if(panelName.equals("Login")){
//			getContentPane().removeAll();
//			getContentPane().add(login);
//			revalidate();
//			repaint();
//		}
//		else if(panelName.equals("Search ID/PW")){
//			getContentPane().removeAll();
//			getContentPane().add(searchID);
//			revalidate();
//			repaint();
//		}
//		else if(panelName.equals("Completion")){
//			getContentPane().removeAll();
//			getContentPane().add(complete);
//			complete.getStatus().setText(Login.id);
////			complete.getName_field().setText(Login.name);
////			complete.get_Id().setText(Login.id);
////			complete.getPassword().setText(Login.pw);
////			complete.getP_num_text().setText(Login.pnum);
////			complete.getNickname_text().setText(Login.nickname);
//			revalidate();
//			repaint();
//		}
//		else {
//			getContentPane().removeAll();
//			getContentPane().add(startPage);
//			revalidate();
//			repaint();
//		}
//	}
//	public static void main(String [] args) {
//		DataBase_main start = new DataBase_main();
////		ConnectMySql con = new ConnectMySql();
//		start.signUp = new SignUp(start);
//		start.login = new Login(start);
//		start.startPage = new StartPage(start);
//		start.searchID = new SearchId(start);
//		start.signUp = new SignUp(start);
//		start.complete = new Completion(start);
//		
//		start.add(start.startPage);
//		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		start.setSize(1200, 800);
//		start.setVisible(true);
////		con.insert("name", "id", "1234", "qkqk", "01056604525", 1);
//	}
//	
////	public JPanel getCompletion() {
////		complete.getStatus().setText(getName());
////		return complete;
////	}
}
