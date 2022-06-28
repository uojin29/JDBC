package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Login extends JPanel{
    private JButton loginBt;
    private StartPage start;

    public Login(StartPage start) {
    	setLayout(null);
		this.start = start;
		
		loginBt = new JButton("Login");
		loginBt.setSize(200, 100);
		loginBt.setLocation(WIDTH/2 + 650, HEIGHT/2 + 300);
		add(loginBt);
		
		loginBt.addActionListener(new MyActionListener());
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			start.change("SignUp");
		}
	}
}
