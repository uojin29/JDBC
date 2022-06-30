package NewJDBC;
import java.awt.*;
import javax.swing.*;

import NewJDBC.Completion.MyActionListener;

import java.awt.event.*;
import java.util.*;

public class Admin extends JPanel{
	private JTextField name_field;
	private JTextField id_field;
	private JPasswordField passwordField;
	private JTextField nickname_text;
	private JTextField p_num_text;
	private JTextField gender_text;
	private JButton cancel, account_withdrawal;
	ConnectMySql con = new ConnectMySql();
	String s = null;
	JLabel status;
	
	public Admin() {
		setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		System.out.println(DataBase_main.userid);
		status = new JLabel("관리자 Page");
		status.setBounds(150, 80, 500, 45);
		status.setFont(new Font("", Font.PLAIN, 40));
		add(status);
		
		JLabel info = new JLabel("<User's Info>");
		info.setBounds(150, 150, 200, 40);
		info.setFont(new Font("", Font.PLAIN, 25));
		add(info);
		con.select();
		
		JPanel base = new JPanel();
		base.setBounds(150, 250, 800, 300);
		base.setBackground(Color.LIGHT_GRAY);
		System.out.println(ConnectMySql.arr.size());
		base.setLayout(new GridLayout(ConnectMySql.arr.size(), 1));
		JLabel s_n = new JLabel("NAME  ID  PW  NICKNAME  P_NUM  GENDER\n");
		s_n.setBounds(150, 200, 650, 40);
		s_n.setFont(new Font("", Font.PLAIN, 20));
		add(s_n);
		for(int i = 0; i < ConnectMySql.arr.size(); i++) {
			JLabel s = new JLabel(ConnectMySql.arr.get(i) + "\n");
			base.add(s);
		}
		add(base);
		
		cancel = new JButton("Cancel");
		cancel.setSize(200, 100);
		cancel.setLocation(350, 600);
		add(cancel);
		cancel.addActionListener(new MyActionListener());
		
		account_withdrawal = new JButton("Account Withdrawal");
		account_withdrawal.setSize(200, 100);
		account_withdrawal.setLocation(550, 600);
		add(account_withdrawal);
		account_withdrawal.addActionListener(new MyActionListener());
		this.setVisible(true);
		DataBase_main.start.add(this);
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("Cancel")) {
				Admin.this.setVisible(false);
				new StartPage();
			}
			else {
				int result = JOptionPane.showConfirmDialog(null, "정말로 모든 계정을 삭제하시겠습니까?", "MESSAGE", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION) {
					con.deleteAll();
					JOptionPane.showMessageDialog(null, "모든 계정을 삭제하였습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					Admin.this.setVisible(false);
					new StartPage();
				}
				else {
					JOptionPane.showMessageDialog(null, "취소하였습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}
}
