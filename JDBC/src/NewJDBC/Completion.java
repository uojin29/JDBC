package NewJDBC;
import java.awt.*;
import javax.swing.*;

import NewJDBC.SignUp.MyActionListener;

import java.awt.event.*;
import java.util.*;

public class Completion extends JPanel{
	private DataBase_main start;
	private JTextField name_field;
	private JTextField id_field;
	private JPasswordField passwordField;
	private JPasswordField confirm_passwordField;
	private JTextField nickname_text;
	private JTextField p_num_text;
	private JButton modify, account_withdrawal;
	
	public Completion(DataBase_main start) {
		setLayout(null);
		this.start = start;
		this.setBackground(Color.LIGHT_GRAY);

		JLabel status = new JLabel("user 님 안녕하세요 :D");
		status.setBounds(150, 100, 500, 40);
		status.setFont(new Font("", Font.PLAIN, 36));
		add(status);
		
		JLabel name = new JLabel("Name: ");
		name.setBounds(350, 200, 200, 40);
		add(name);
		
		name_field = new JTextField();
		name_field.setBounds(500, 200, 350, 40);
		name_field.setEnabled(false);
		add(name_field);
		name_field.setColumns(10);
		
		JLabel idLbl = new JLabel("ID: ");
		idLbl.setBounds(350, 250, 200, 40);
		add(idLbl);
		
		id_field = new JTextField();
		id_field.setBounds(500, 250, 350, 40);
		id_field.setEnabled(false);
		add(id_field);
		id_field.setColumns(10);
		
		JLabel pwLbl = new JLabel("PassWord: ");
		pwLbl.setBounds(350, 300, 200, 40);
		add(pwLbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(500, 300, 350, 40);
		passwordField.setEnabled(false);
		add(passwordField);
		
		JLabel c_pwLbl = new JLabel("Confirm Password: ");
		c_pwLbl.setBounds(350, 350, 200, 40);
		name_field.setEnabled(false);
		add(c_pwLbl);
		
		confirm_passwordField = new JPasswordField();
		confirm_passwordField.setBounds(500, 350, 350, 40);
		add(confirm_passwordField);
		
		JLabel nickname = new JLabel("NickName: ");
		nickname.setBounds(350, 400, 200, 40);
		add(nickname);
		
		nickname_text = new JTextField();
		nickname_text.setBounds(500, 400, 350, 40);
		add(nickname_text);
		
		JLabel p_num = new JLabel("Phone Number: ");
		p_num.setBounds(350, 450, 200, 40);
		add(p_num);
		
		p_num_text = new JTextField();
		p_num_text.setBounds(500, 450, 350, 40);
		add(p_num_text);
		modify = new JButton("Modify");
		modify.setSize(200, 100);
		modify.setLocation(400, 600);
		add(modify);
		modify.addActionListener(new MyActionListener());
		
		account_withdrawal = new JButton("Account Withdrawal");
		account_withdrawal.setSize(200, 100);
		account_withdrawal.setLocation(600, 600);
		add(account_withdrawal);
		account_withdrawal.addActionListener(new MyActionListener());
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("Modify")) {
				JOptionPane.showMessageDialog(null, "개인정보가 수정되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				start.change("Completion");
			}
			else if(s.equals("Account Withdrawal")){
				JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				start.change("");
			}
		}
	}
}
