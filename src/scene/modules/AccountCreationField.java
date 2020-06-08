package scene.modules;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import scene.SignUpFrame;
import utitlity.Constants;

public class AccountCreationField extends JPanel {
	
	public JLabel id;
	public JTextField inputID;
	
	public JLabel password;
	public JPasswordField inputPassword;
	
	public JLabel passwordConfirm;
	public JPasswordField inputPasswordConfirm;
	
	public JLabel phonNumber;
	public JTextField inputPhonNumber;
	
	public JLabel email;
	public JTextField inputEmail;
	
	public JPanel socialSecurityNumber;
	public JLabel socialNumber;
	public JTextField birth;
	public JLabel Hyphen;
	public JTextField sex;
	public JLabel securityNumber;
	
	public JLabel adress;
	public JTextField InputAdress;
	
	public JButton CreationButton;
	
	public AccountCreationField(SignUpFrame Frame) {
		
		setLayout(null);
		
		id = new JLabel("아이디 ");
		inputID = new JTextField();
		
		password = new JLabel("비밀번호 ");
		inputPassword = new JPasswordField();
		
		passwordConfirm = new JLabel("비밀번호 확인");
		inputPasswordConfirm = new JPasswordField();
		
		phonNumber  = new JLabel("휴대폰 번호");
		inputPhonNumber = new JTextField();
		
		email  = new JLabel("이메일");
		inputEmail = new JTextField();
		
		initializeSocialSecurityNumber();
		socialNumber = new JLabel("주민번호");
		
		adress  = new JLabel("주소");
		InputAdress = new JTextField();
		
		CreationButton = new JButton("회원가입");
		
		this.setBackground(new Color(181,230,29));
		
		
		locateComponent(id,0);
		locateComponent(inputID,1);
		
		locateComponent(password,2);
		locateComponent(inputPassword,3);
		
		locateComponent(passwordConfirm,4);
		locateComponent(inputPasswordConfirm,5);
		
		locateComponent(phonNumber,6);
		locateComponent(inputPhonNumber,7);
		
		locateComponent(email,8);
		locateComponent(inputEmail,9);
		
		locateComponent(socialNumber,10);
		locateComponent(socialSecurityNumber,11);
		
		locateComponent(adress,12);
		locateComponent(InputAdress,13);
		
		locateComponent(CreationButton,14);

		add(id);
		add(inputID);		
		add(password);
		add(inputPassword);
		add(passwordConfirm);
		add(inputPasswordConfirm);
		add(phonNumber);
		add(inputPhonNumber);
		add(email);
		add(inputEmail);
		add(socialNumber);
		add(socialSecurityNumber);
		add(adress);
		add(InputAdress);		
		add(CreationButton);
	}
	
	private void initializeSocialSecurityNumber() {
		socialSecurityNumber = new JPanel();	
		
		socialSecurityNumber.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		birth = new JTextField(14);
		Hyphen = new JLabel("-");
		sex = new JTextField(2);
		securityNumber  = new JLabel("●●●●●●●");
		
		socialSecurityNumber.setBackground(new Color(181,230,29));
		
		
		birth.setSize(0, 80);
		
		socialSecurityNumber.add(birth);
		socialSecurityNumber.add(Hyphen);
		socialSecurityNumber.add(sex);
		socialSecurityNumber.add(securityNumber);
	}
	
	private void locateComponent(Component component, int order) {
		component.setBounds(Constants.ACCOUNTINPUT_X,Constants.ACCOUNTINPUT_Y + order*Constants.ACCOUNTINPUT_GAP,Constants.ACCOUNTINPUT_WIDTH, Constants.ACCOUNTINPUT_HEIGHT);
	}
}
