package NewJDBC;
import java.awt.*;
import javax.swing.*;

import NewJDBC.Login.MyActionListener;

import java.awt.event.*;
import java.util.*;

public class SignUp extends JPanel{
	private JButton signBt, loginBt;
    private StartPage start;

    public SignUp(StartPage start) {
		this.start = start;
		setLayout(null);
		
		signBt = new JButton("SignUp");
		signBt.setSize(200, 100);
		signBt.setLocation(WIDTH/2 + 350, HEIGHT/2 + 300);
		add(signBt);
		
		signBt.addActionListener(new MyActionListener());
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			start.change("Login");
		}
	}
}
