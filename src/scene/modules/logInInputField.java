package scene.modules;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utitlity.Constants;

public class logInInputField extends JPanel{
	
	public JTextField inputID;
	public JTextField inputPassword;
	public JButton logInButton;
	
	public JPanel serchingAndCreatingAccount;
	public JButton searchByID;
	public JButton searchByPassword;
	public JButton AccountCreation;
	
	public logInInputField() {
		
		
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
		
		inputID.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {				
				if(inputID.getText().equals("아이디를 입력하세요"))inputID.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(inputID.getText().equals("")) inputID.setText("아이디를 입력하세요");
			}
			
		});
		
		inputPassword.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {				
				if(inputPassword.getText().equals("비밀번호를 입력하세요"))inputPassword.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(inputPassword.getText().equals("")) inputPassword.setText("비밀번호를 입력하세요");
			}
			
		});
		
		
		//패널 설정
		serchingAndCreatingAccount.setLayout(new FlowLayout());
		serchingAndCreatingAccount.add(searchByID);
		serchingAndCreatingAccount.add(searchByPassword);
		serchingAndCreatingAccount.add(AccountCreation);
		serchingAndCreatingAccount.setBackground(new Color(181,230,29));
		
		this.setBackground(new Color(181,230,29));
		
		//컴포넌트 위치 
		inputID.setBounds(Constants.COMPONENT_X,Constants.COMPONENT_INIT_Y,Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		inputPassword.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y + Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		logInButton.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  + 2*Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		serchingAndCreatingAccount.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  +3*Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
				
		
		add(inputID);
		add(inputPassword);
		add(logInButton);
		add(serchingAndCreatingAccount);

	}
	
}
