package scene.modules;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class logInInputField extends JPanel{
	
	public JTextField inputID;
	public JTextField inputPassword;
	public JButton logInButton;
	
	public JPanel serchingAndCreatingAccount;
	public JButton searchByID;
	public JButton searchByPassword;
	public JButton AccountCreation;
	
	public logInInputField() {
		
		//setLayout(new GridLayout(0,1,10,10));
		setLayout(null);

		//아이디와 비밀번호, 로그인 버튼 생성
		inputID = new JTextField("아이디를 입력하세요");
		inputPassword = new JTextField("비밀번호를 입력하세요");
		logInButton = new JButton("로그인");
		
		
		//계정찾기, 회원가입 버튼 패널과 버튼 생성
		serchingAndCreatingAccount = new JPanel();
		searchByID = new JButton("아이디로 찾기");
		searchByPassword = new JButton("비밀번호로 찾기");
		AccountCreation = new JButton("회원가입");	
		
		//위치
		inputID.setBounds(this.getX(), 10, 200, 40);
		inputPassword.setBounds(this.getWidth(), 60, 200, 40);
		logInButton.setBounds(this.getWidth(), 110 , 200, 40);
		serchingAndCreatingAccount.setBounds(10, 160, 200, 40);
		
		//패널 설정
		serchingAndCreatingAccount.setLayout(new GridLayout(0,3));
		serchingAndCreatingAccount.add(searchByID);
		serchingAndCreatingAccount.add(searchByPassword);
		serchingAndCreatingAccount.add(AccountCreation);
		
		add(inputID);
		add(inputPassword);
		add(logInButton);
		add(serchingAndCreatingAccount);

	}
	
}
