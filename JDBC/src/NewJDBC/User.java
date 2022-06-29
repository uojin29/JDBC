//package NewJDBC;
//import java.awt.*;
//import javax.swing.*;
//
//import NewJDBC.SignUp.MyItemListener;
//
//import java.awt.event.*;
//import java.util.*;
//
//public class User extends JPanel{
//	private JTextField name_field;
//	private JTextField id_field;
//	private JPasswordField passwordField;
//	private JPasswordField confirm_passwordField;
//	private JTextField nickname_text;
//	private JTextField p_num_text;
//	
//	public User(DataBase_main start) {
//		JLabel name = new JLabel("Name: ");
//		name.setBounds(350, 200, 200, 40);
//		add(name);
//		
//		name_field = new JTextField();
//		name_field.setBounds(500, 200, 350, 40);
//		name_field.setEnabled(false);
//		add(name_field);
//		name_field.setColumns(10);
//		
//		JLabel idLbl = new JLabel("ID: ");
//		idLbl.setBounds(350, 250, 200, 40);
//		add(idLbl);
//		
//		id_field = new JTextField();
//		id_field.setBounds(500, 250, 350, 40);
//		name_field.setEnabled(false);
//		add(id_field);
//		id_field.setColumns(10);
//		
//		JLabel pwLbl = new JLabel("PassWord: ");
//		pwLbl.setBounds(350, 300, 200, 40);
//		add(pwLbl);
//		
//		passwordField = new JPasswordField();
//		passwordField.setBounds(500, 300, 350, 40);
//		name_field.setEnabled(false);
//		add(passwordField);
//		
//		JLabel c_pwLbl = new JLabel("Confirm Password: ");
//		c_pwLbl.setBounds(350, 350, 200, 40);
//		name_field.setEnabled(false);
//		add(c_pwLbl);
//		
//		confirm_passwordField = new JPasswordField();
//		confirm_passwordField.setBounds(500, 350, 350, 40);
//		add(confirm_passwordField);
//		
//		JLabel nickname = new JLabel("NickName: ");
//		nickname.setBounds(350, 400, 200, 40);
//		add(nickname);
//		
//		nickname_text = new JTextField();
//		nickname_text.setBounds(500, 400, 350, 40);
//		add(nickname_text);
//		
//		JLabel p_num = new JLabel("Phone Number: ");
//		p_num.setBounds(350, 450, 200, 40);
//		add(p_num);
//		
//		p_num_text = new JTextField();
//		p_num_text.setBounds(500, 450, 350, 40);
//		add(p_num_text);
//		
//	}
//	
//}
