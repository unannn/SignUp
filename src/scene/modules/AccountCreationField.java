package scene.modules;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import scene.SignUpFrame;
import utitlity.Constants;

import java.util.regex.*;

public class AccountCreationField extends JPanel {
	
	public JLabel id;
	public JTextField inputID;
	
	public JLabel password;
	public JPasswordField inputPassword;
	
	public JLabel passwordConfirm;
	public JPasswordField inputPasswordConfirm;
	
	public JLabel phoneNumber;
	public JTextField inputPhoneNumber;
	
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
	
	public String _id;
	public String _password;
	public String _phoneNumber;
	public String _email;
	public String _birth;
	public String _sex;
	public String _adress;
	
	public JLabel idError;
	public JLabel passwordError;
	public JLabel paaswordConfirmError;
	public JLabel phoneNumberError;
	public JLabel securityNumberError;
	public JLabel adressError;
	
	
	public JButton CreationButton;
	
	public AccountCreationField(SignUpFrame frame) {
		
		setLayout(null);
		
		id = new JLabel("아이디(영문숫자로 2~20자)");
		inputID = new JTextField();
		idError = new JLabel("a ");
		
		password = new JLabel("비밀번호(영문숫자로 2~20자) ");
		inputPassword = new JPasswordField();
		passwordError = new JLabel("a ");

		passwordConfirm = new JLabel("비밀번호 확인");
		inputPasswordConfirm = new JPasswordField();
		paaswordConfirmError = new JLabel("a ");
		
		phoneNumber  = new JLabel("휴대폰 번호('-'없이)");
		inputPhoneNumber = new JTextField();
		phoneNumberError = new JLabel("a ");
		
		email  = new JLabel("이메일");
		inputEmail = new JTextField();
		
		initializeSocialSecurityNumber();
		socialNumber = new JLabel("주민번호");
		securityNumberError = new JLabel("a ");
		
		adress  = new JLabel("주소(●●시 ●●구 ●●●)");
		InputAdress = new JTextField();
		adressError = new JLabel("a ");
		
		CreationButton = new JButton("회원가입");
		
		this.setBackground(new Color(181,230,29));
		
		//좌표설정
		locateComponent(id,0);
		locateComponent(inputID,1);
		
		locateComponent(password,2);
		locateComponent(inputPassword,3);
		
		locateComponent(passwordConfirm,4);
		locateComponent(inputPasswordConfirm,5);
		
		locateComponent(phoneNumber,6);
		locateComponent(inputPhoneNumber,7);
		
		locateComponent(email,8);
		locateComponent(inputEmail,9);
		
		locateComponent(socialNumber,10);
		locateComponent(socialSecurityNumber,11);
		
		locateComponent(adress,12);
		locateComponent(InputAdress,13);
		
		locateComponent(CreationButton,15);
		
		idError.setBounds(250, Constants.ACCOUNTINPUT_Y + 0*Constants.ACCOUNTINPUT_GAP, 190, 40);
		passwordError.setBounds(260, Constants.ACCOUNTINPUT_Y + 2*Constants.ACCOUNTINPUT_GAP, 190, 40);
		paaswordConfirmError.setBounds(170, Constants.ACCOUNTINPUT_Y + 4*Constants.ACCOUNTINPUT_GAP, 190, 40);
		phoneNumberError.setBounds(210, Constants.ACCOUNTINPUT_Y + 6*Constants.ACCOUNTINPUT_GAP, 190, 40);
		securityNumberError.setBounds(140, Constants.ACCOUNTINPUT_Y + 10*Constants.ACCOUNTINPUT_GAP, 190, 40);
		adressError.setBounds(250, Constants.ACCOUNTINPUT_Y + 12*Constants.ACCOUNTINPUT_GAP, 190, 40);
		
		
		//글자수 제한
		limitCharcaterNumber(inputID,Constants.ID_LIMIT);
		limitCharcaterNumber(inputPassword,Constants.PASSWORD_LIMIT);
		limitCharcaterNumber(inputPasswordConfirm,Constants.PASSWORD_LIMIT);
		limitCharcaterNumber(inputPhoneNumber,11);
		limitCharcaterNumber(inputEmail,40);		
		limitCharcaterNumber(InputAdress,40);

		
		add(id);
		add(inputID);		
		add(password);
		add(inputPassword);
		add(passwordConfirm);
		add(inputPasswordConfirm);
		add(phoneNumber);
		add(inputPhoneNumber);
		add(email);
		add(inputEmail);
		add(socialNumber);
		add(socialSecurityNumber);
		add(adress);
		add(InputAdress);		
		
		add(CreationButton);
		
		add(idError);
		add(passwordError);
		add(phoneNumberError);
		add(securityNumberError);
		add(adressError);
		add(paaswordConfirmError);
		
		CreationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pattern = "[0-9a-zA-Z]{2,20}";
				if(inputPassword.getText().contentEquals(inputPasswordConfirm.getText())) {
					paaswordConfirmError.setText(" ");
					
					if(inputID.getText().matches(pattern) && inputID.getText().length() >= 2) {
						_id = inputID.getText();
						idError.setText(" ");
					}
					else {
						_id = null;
						idError.setForeground(Color.RED);
						idError.setText("다시입력해주세요");
					}
					
					if(inputPassword.getText().matches(pattern) && inputPassword.getText().length() >= 2) {
						_password = inputPassword.getText();
						passwordError.setText(" ");
					}
					else {
						_password = null;
						passwordError.setForeground(Color.RED);
						passwordError.setText("다시입력해주세요");
					}
					
					if(inputPhoneNumber.getText().matches("[0-9]") && inputPhoneNumber.getText().length() == 11) {
						_phoneNumber = inputPhoneNumber.getText();
						phoneNumberError.setText(" ");
					}
					else {
						_phoneNumber = null;
						phoneNumberError.setForeground(Color.RED);
						phoneNumberError.setText("다시입력해주세요");						
					}
					
					_email = inputEmail.getText();
					
					if(birth.getText().matches("[0-9]") && birth.getText().length() == 6) {
						_birth = birth.getText();
						securityNumberError.setText(" ");
					}
					else {
						_birth = null;
						securityNumberError.setForeground(Color.RED);
						securityNumberError.setText("다시입력해주세요");				
					}
					
					if(sex.getText().matches("[0-9]") && sex.getText().length() == 1) {
						_sex = sex.getText();
						securityNumberError.setText(" ");
					}
					else {
						_sex = null;
						securityNumberError.setForeground(Color.RED);
						securityNumberError.setText("다시입력해주세요");		
					}
					
					if(InputAdress.getText().matches("[가-힣]{2,4}시\\s[가-힣]{1,3}구\\s[가-힣0-9]{1,10}")) {
						_adress = InputAdress.getText();		
						adressError.setText(" ");
					}
					else {
						_adress = null;
						adressError.setForeground(Color.RED);
						adressError.setText("다시입력해주세요");		
					}
					
					if(_id != null && _password != null && _phoneNumber != null && _birth != null && _sex != null && _adress != null) {
						Database.getInstance().createNewAccount(_id, _password, _phoneNumber, _email,  _birth,  _sex,  _adress);
						frame.change("LogIn");
					}					
				}else {
					paaswordConfirmError.setForeground(Color.RED);
					paaswordConfirmError.setText("다시입력해주세요");	
				}
				
			}
			
		});
	}
	
	private void initializeSocialSecurityNumber() {
		socialSecurityNumber = new JPanel();	
		
		socialSecurityNumber.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		birth = new JTextField(14);
		Hyphen = new JLabel("-");
		sex = new JTextField(2);
		securityNumber  = new JLabel("●●●●●●●");
		
		limitCharcaterNumber(birth,6);
		limitCharcaterNumber(sex,1);
		
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
	
	private void limitCharcaterNumber(JTextField field,int limit) {
		field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				JTextField src = (JTextField)e.getSource();
				if(src.getText().length() >= limit) e.consume();
			}
		});
	}	
}
