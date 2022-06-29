package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StartPage extends JPanel{
	
	private JButton signBt, loginBt;
    private DataBase_main start;
//    StartPage(){
//    	DataBase_main.start.add(this);
//    }
    public StartPage() {
		this.start = start;
		setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		JLabel status = new JLabel("<Start>");
		status.setFont(new Font("", Font.PLAIN, 55));
		status.setBounds(500, 70, 500, 100);
		add(status);
		
		signBt = new JButton("SignUp");
		signBt.setSize(200, 100);
		signBt.setLocation(350, 300);
		add(signBt);
		
		loginBt = new JButton("Login");
		loginBt.setSize(200, 100);
		loginBt.setLocation(650, 300);
		add(loginBt);
		
		signBt.addActionListener(new MyActionListener());
		loginBt.addActionListener(new MyActionListener());
		this.setVisible(true);
		DataBase_main.start.add(this);
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("SignUp")) {
				//start.change("SignUp");
				new SignUp();
				StartPage.this.setVisible(false);
			}
			else if(s.equals("Login")){
				//start.change("Login");
				new Login();
				StartPage.this.setVisible(false);
			}
		}
	}
}
