package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SearchId extends JPanel{
	private JTextField name_text;
	private JTextField nickname_text;
	private JTextField p_num_field;
	private JButton cancel, search;
	ConnectMySql con = new ConnectMySql();
	
	public SearchId(){
		setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		JLabel status = new JLabel("<Search>");
		status.setFont(new Font("", Font.PLAIN, 55));
		status.setBounds(500, 70, 500, 100);
		add(status);

		JLabel name = new JLabel("Name: ");
		name.setBounds(350, 300, 200, 40);
		add(name);
		
		name_text = new JTextField();
		name_text.setBounds(500, 300, 350, 40);
		add(name_text);
		name_text.setColumns(10);
		
		JLabel nickname = new JLabel("NickName: ");
		nickname.setBounds(350, 350, 200, 40);
		add(nickname);
		
		nickname_text = new JTextField();
		nickname_text.setBounds(500, 350, 350, 40);
		add(nickname_text);
		
		cancel = new JButton("Cancel");
		cancel.setSize(200, 100);
		cancel.setLocation(400, 500);
		add(cancel);
		cancel.addActionListener(new MyActionListener());
		
		search = new JButton("Search");
		search.setSize(200, 100);
		search.setLocation(600, 500);
		add(search);
		search.addActionListener(new MyActionListener());
		DataBase_main.start.add(this);
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("Cancel")) {
				JOptionPane.showMessageDialog(null, "실행취소", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				new Login();
				SearchId.this.setVisible(false);
			}
			else if(s.equals("Search")){
				if(con.existAccount(name_text.getText(), nickname_text.getText()) != 0) {
					JOptionPane.showMessageDialog(null, "Id: " + con.searchid(name_text.getText(), nickname_text.getText()) + 
							"\nPassWord: "+ con.searchpw(name_text.getText(), nickname_text.getText()), "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					new Login();
					SearchId.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "일치하는 계정 정보가 없습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}	
			}
		}
	}
}
