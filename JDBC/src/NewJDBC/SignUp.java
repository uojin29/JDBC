package NewJDBC;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUp extends JPanel{
	private JTextField name_field;
	private JTextField id_field;
	private JButton idCheck;
	private JPasswordField passwordField;
	private JPasswordField confirm_passwordField;
	private JTextField nickname_text;
	private JTextField p_num_text;
	private JCheckBox male, female;
	private ButtonGroup group;
	private JButton cancel, completion;
	private int g;
	private int flag = 0;
	ConnectMySql con = new ConnectMySql();
    
	public SignUp() {
		setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		group = new ButtonGroup();
		
		JLabel status = new JLabel("<Sign Up>");
		status.setFont(new Font("", Font.PLAIN, 55));
		status.setBounds(450, 70, 500, 100);
		add(status);
		
		JLabel name = new JLabel("* Name: ");
		name.setBounds(350, 200, 200, 40);
		add(name);
		
		name_field = new JTextField();
		name_field.setBounds(500, 200, 350, 40);
		add(name_field);
		name_field.setColumns(10);
		
		JLabel idLbl = new JLabel("* ID: ");
		idLbl.setBounds(350, 250, 200, 40);
		add(idLbl);
		
		id_field = new JTextField();
		id_field.setBounds(500, 250, 350, 40);
		add(id_field);
		id_field.setColumns(10);
		
		idCheck = new JButton("✓");
		idCheck.setBounds(850, 245, 55, 55);
		idCheck.setOpaque(true);//배경색 적용을 허용하겠다.
		idCheck.setBorderPainted(false);	//포커스 표시 설
		//idCheck.setBackground(Color.WHITE);
		add(idCheck);
		idCheck.addActionListener(new MyActionListener());
		
		JLabel pwLbl = new JLabel("* PassWord: ");
		pwLbl.setBounds(350, 300, 200, 40);
		add(pwLbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(500, 300, 350, 40);
		add(passwordField);
		
		JLabel c_pwLbl = new JLabel("* Confirm Password: ");
		c_pwLbl.setBounds(350, 350, 200, 40);
		add(c_pwLbl);
		
		confirm_passwordField = new JPasswordField();
		confirm_passwordField.setBounds(500, 350, 350, 40);
		add(confirm_passwordField);
		
		JLabel nickname = new JLabel("* NickName: ");
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
		
		JLabel gender = new JLabel("Gender: ");
		gender.setBounds(350, 500, 200, 40);
		add(gender);
		
		male = new JCheckBox("Male", true);
		male.setBounds(500, 500, 100, 40);
		group.add(male);
		add(male);
		
		female = new JCheckBox("Female");
		female.setBounds(600, 500, 100, 40);
		group.add(female);
		add(female);
		
		cancel = new JButton("Cancel");
		cancel.setSize(200, 100);
		cancel.setLocation(400, 600);
		add(cancel);
		cancel.addActionListener(new MyActionListener());
		
		completion = new JButton("Completion");
		completion.setSize(200, 100);
		completion.setLocation(600, 600);
		add(completion);
		completion.addActionListener(new MyActionListener());
		this.setVisible(true);
		DataBase_main.start.add(this);
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("✓")) {
				flag = 1;
				idCheck.setOpaque(true);//배경색 적용을 허용하겠다.
				idCheck.setBorderPainted(false);
				idCheck.setBackground(Color.PINK);
				if(id_field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
				else if(con.duplicate(id_field.getText()) != 0) {
					JOptionPane.showMessageDialog(null, "ID가 중복입니다. 다시 입력하세요.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
				else if(con.duplicate(id_field.getText()) == 0) {
					JOptionPane.showMessageDialog(null, "ID가 입력되었습니다.", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					idCheck.setSelected(true);
				}
			}
			
			if(s.equals("Cancel")) {
				SignUp.this.setVisible(false);
				new StartPage();
			}
			else if(s.equals("Completion")){
				if(passwordField.getText().equals(confirm_passwordField.getText())&& !passwordField.getText().isEmpty() && !id_field.getText().isEmpty() 
						&& !nickname_text.getText().isEmpty() && !name_field.getText().isEmpty() && flag == 1) {
					if(male.isSelected()) {
						g = 0;
					}
					else if(female.isSelected()) {
						g = 1;
					}
					con.insert(name_field.getText(), id_field.getText(), passwordField.getText(), nickname_text.getText(), p_num_text.getText(), g);
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다!", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
					name_field.setText(null);
					id_field.setText(null);
					passwordField.setText(null);
					confirm_passwordField.setText(null);
					nickname_text.setText(null);
					p_num_text.setText(null);
					male.setSelected(true);
					female.setSelected(false);
					flag = 0;
					idCheck.setBackground(Color.WHITE);
					new StartPage();
					SignUp.this.setVisible(false);
				}
				else if(!passwordField.getText().equals(confirm_passwordField.getText())){
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
				else if(flag != 1){
					JOptionPane.showMessageDialog(null, "ID 중복확인을 해주세요", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "필수 항목을 다 입력하세요", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}
}