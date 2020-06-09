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

	
	
	public JButton CreationButton;
	
	public AccountCreationField(SignUpFrame frame) {
		
		setLayout(null);
		
		id = new JLabel("���̵� ");
		inputID = new JTextField();
		
		password = new JLabel("��й�ȣ ");
		inputPassword = new JPasswordField();
		
		passwordConfirm = new JLabel("��й�ȣ Ȯ��");
		inputPasswordConfirm = new JPasswordField();
		
		phoneNumber  = new JLabel("�޴��� ��ȣ");
		inputPhoneNumber = new JTextField();
		
		email  = new JLabel("�̸���");
		inputEmail = new JTextField();
		
		initializeSocialSecurityNumber();
		socialNumber = new JLabel("�ֹι�ȣ");
		
		adress  = new JLabel("�ּ�");
		InputAdress = new JTextField();
		
		CreationButton = new JButton("ȸ������");
		
		this.setBackground(new Color(181,230,29));
		
		//��ǥ����
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
		
		//���ڼ� ����
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
		
		CreationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println( inputPassword.getText() +" "+ inputPasswordConfirm.getText());
				if(inputPassword.getText().contentEquals(inputPasswordConfirm.getText())) {
					_id = inputID.getText();
					_password = inputPassword.getText();
					_phoneNumber = inputPhoneNumber.getText();
					_email = inputEmail.getText();
					_birth =birth.getText();
					_sex = sex.getText();
					_adress = InputAdress.getText();				
					Database.getInstance().createNewAccount(_id, _password, _phoneNumber, _email,  _birth,  _sex,  _adress);
					frame.change("LogIn");
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
		securityNumber  = new JLabel("�ܡܡܡܡܡܡ�");
		
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
