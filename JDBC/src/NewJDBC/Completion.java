package NewJDBC;
import java.awt.*;
import javax.swing.*;

//import NewJDBC.SignUp.MyActionListener;

import java.awt.event.*;
import java.util.*;

public class Completion extends JPanel{
	private JTextField name_field;
	private JTextField id_field;
	private JPasswordField passwordField;
	private JTextField nickname_text;
	private JTextField p_num_text;
	private JTextField gender_text;
	private JButton modify, account_withdrawal;
	ConnectMySql con = new ConnectMySql();
	String s = null;
	JLabel status;
	
	public Completion() {
		setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		System.out.println(DataBase_main.userid);
		status = new JLabel(DataBase_main.userid + "님 안녕하세요 :D");
		status.setBounds(150, 100, 500, 40);
		status.setFont(new Font("", Font.PLAIN, 36));
		add(status);
		
		JLabel name = new JLabel("Name: ");
		name.setBounds(350, 200, 200, 40);
		add(name);
		
		name_field = new JTextField();
		name_field.setBounds(500, 200, 350, 40);
		name_field.setText(con.name(DataBase_main.userid));
		add(name_field);
		name_field.setColumns(10);
		
		JLabel idLbl = new JLabel("ID: ");
		idLbl.setBounds(350, 250, 200, 40);
		idLbl.setEnabled(false);
		add(idLbl);
		
		id_field = new JTextField();
		id_field.setBounds(500, 250, 350, 40);
		id_field.setEnabled(false);
		id_field.setText(con.id(DataBase_main.userid));
		add(id_field);
		id_field.setColumns(10);
		
		JLabel pwLbl = new JLabel("PassWord: ");
		pwLbl.setBounds(350, 300, 200, 40);
		add(pwLbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(500, 300, 350, 40);
		passwordField.setText(con.login(DataBase_main.userid));
		add(passwordField);
		
		JLabel nickname = new JLabel("NickName: ");
		nickname.setBounds(350, 350, 200, 40);
		nickname.setEnabled(false);
		add(nickname);
		
		nickname_text = new JTextField();
		nickname_text.setBounds(500, 350, 350, 40);
		nickname_text.setText(con.n_name(DataBase_main.userid));
		nickname_text.setEnabled(false);
		add(nickname_text);
		
		JLabel p_num = new JLabel("Phone Number: ");
		p_num.setBounds(350, 400, 200, 40);
		add(p_num);
		
		p_num_text = new JTextField();
		p_num_text.setBounds(500, 400, 350, 40);
		p_num_text.setText(con.p_num(DataBase_main.userid));
		add(p_num_text);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setBounds(350, 450, 200, 40);
		add(gender);
		
		gender_text = new JTextField();
		gender_text.setBounds(500, 450, 350, 40);
		
		if(con.gender(DataBase_main.userid) == 0) s = "Male";
		else s = "Female";
		gender_text.setText(s);
		
		add(gender_text);
		
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
		this.setVisible(true);
		DataBase_main.start.add(this);
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("Modify")) {
			//	con.update();
				JOptionPane.showMessageDialog(null, "개인정보가 수정되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
			}
			else if(s.equals("Account Withdrawal")){
				JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				new StartPage();
				Completion.this.setVisible(false);
			}
		}
	}
}
