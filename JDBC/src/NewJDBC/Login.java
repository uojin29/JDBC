package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Login extends JPanel{
	private JTextField id_field;
	private JPasswordField passwordField;
	private DataBase_main start;
	private JButton searchB, log_Completion;
	//static String id ;
	ConnectMySql con = new ConnectMySql();
    
	public Login() {
		setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		JLabel status = new JLabel("<Login>");
		status.setFont(new Font("", Font.PLAIN, 55));
		status.setBounds(500, 70, 500, 100);
		add(status);

		JLabel idLbl = new JLabel("ID: ");
		idLbl.setBounds(350, 300, 200, 40);
		add(idLbl);
		
		id_field = new JTextField();
		id_field.setBounds(500, 300, 350, 40);
		add(id_field);
		id_field.setColumns(10);
		
		JLabel pwLbl = new JLabel("PassWord: ");
		pwLbl.setBounds(350, 350, 200, 40);
		add(pwLbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(500, 350, 350, 40);
		add(passwordField);
		
		searchB = new JButton("Search ID/PW");
		searchB.setSize(200, 100);
		searchB.setLocation(400, 500);
		add(searchB);
		searchB.addActionListener(new MyActionListener());
		
		log_Completion = new JButton("Completion");
		log_Completion.setSize(200, 100);
		log_Completion.setLocation(600, 500);
		add(log_Completion);
		log_Completion.addActionListener(new MyActionListener());
		DataBase_main.start.add(this);
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();
			if(s.equals("Search ID/PW")) {
				ConnectMySql.select();
				new SearchId();
				Login.this.setVisible(false);
			}
			else if(s.equals("Completion")){
				
				if(con.login(id_field.getText()).equals(passwordField.getText())){
					DataBase_main.userid = id_field.getText();
					System.out.println(DataBase_main.userid + " "+ id_field.getText());
				//	ConnectMySql.user_id = id_field.getText();
					System.out.println(ConnectMySql.user_id);
					new Completion();
					Login.this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 다시 입력하세요.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}
}
