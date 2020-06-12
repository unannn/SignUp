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
	public RoundedJTextField inputID;
	
	public JLabel password;
	public RoundedPasswordField inputPassword;
	
	public JLabel passwordConfirm;
	public RoundedPasswordField inputPasswordConfirm;
	
	public JLabel phoneNumber;
	public RoundedJTextField inputPhoneNumber;
	
	public JLabel email;
	public RoundedJTextField inputEmail;
	
	public JPanel socialSecurityNumber;
	public JLabel socialNumber;
	public RoundedJTextField birth;
	public JLabel Hyphen;
	public RoundedJTextField sex;
	public JLabel securityNumber;
	
	public JLabel adress;
	public RoundedJTextField InputAdress;
	
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
	public JLabel birthError;
	public JLabel sexError;
	public JLabel adressError;
	
	
	public JLabel CreationButton;
	
	public AccountCreationField(SignUpFrame frame) {
		
		setLayout(null);
		
		id = new JLabel("¾ÆÀÌµğ(¿µ¹®¼ıÀÚ·Î 2~20ÀÚ)");
		inputID = new RoundedJTextField(15);
		idError = new JLabel(" ");
		
		password = new JLabel("ºñ¹Ğ¹øÈ£(¿µ¹®¼ıÀÚ·Î 2~20ÀÚ) ");
		inputPassword = new RoundedPasswordField(15);
		passwordError = new JLabel(" ");
		
	
		passwordConfirm = new JLabel("ºñ¹Ğ¹øÈ£ È®ÀÎ");
		inputPasswordConfirm = new RoundedPasswordField(15);
		paaswordConfirmError = new JLabel(" ");
		
		phoneNumber  = new JLabel("ÈŞ´ëÆù ¹øÈ£('-'¾øÀÌ)");
		inputPhoneNumber = new RoundedJTextField(15);
		phoneNumberError = new JLabel(" ");
		
		email  = new JLabel("ÀÌ¸ŞÀÏ");
		inputEmail = new RoundedJTextField(15);
		
		initializeSocialSecurityNumber();
		socialNumber = new JLabel("ÁÖ¹Î¹øÈ£");
		birthError = new JLabel(" ");
		sexError = new JLabel(" ");
		
		adress  = new JLabel("ÁÖ¼Ò(¡Ü¡Ü½Ã ¡Ü¡Ü±¸ ¡Ü¡Ü¡Ü)");
		InputAdress = new RoundedJTextField(15);
		adressError = new JLabel(" ");
		
		CreationButton = new JLabel(Constants.SIGN_UP);
		
		this.setBackground(new Color(181,230,29));
		
		//ÁÂÇ¥¼³Á¤
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
		birthError.setBounds(160, Constants.ACCOUNTINPUT_Y + 10*Constants.ACCOUNTINPUT_GAP, 190, 40);
		sexError.setBounds(160, Constants.ACCOUNTINPUT_Y + 10*Constants.ACCOUNTINPUT_GAP, 190, 40);
		adressError.setBounds(250, Constants.ACCOUNTINPUT_Y + 12*Constants.ACCOUNTINPUT_GAP, 190, 40);
		
		
		//±ÛÀÚ¼ö Á¦ÇÑ
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
		add(birthError);
		add(sexError);
		add(adressError);
		add(paaswordConfirmError);
		
		CreationButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pattern = "[0-9a-zA-Z]{2,20}";
				if(inputPassword.getText().contentEquals(inputPasswordConfirm.getText())) {
					paaswordConfirmError.setText(" ");
					
					if(inputID.getText().matches(pattern) && inputID.getText().length() >= 2) {
						if(!Database.getInstance().searchSameData("id", inputID.getText())) {
							_id = inputID.getText();
							idError.setText(" ");
						}
						else {
							_id = null;
							idError.setForeground(Color.RED);
							idError.setText("ÀÌ¹Ì °°Àº ¾ÆÀÌµğ°¡ Á¸ÀçÇÕ´Ï´Ù");
						}						
					}
					else {
						_id = null;
						idError.setForeground(Color.RED);
						idError.setText("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù");
					}
					
					if(inputPassword.getText().matches(pattern) && inputPassword.getText().length() >= 2) {
						_password = inputPassword.getText();
						passwordError.setText(" ");
					}
					else {
						_password = null;
						passwordError.setForeground(Color.RED);
						passwordError.setText("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù");
					}
					if(inputPhoneNumber.getText().matches("[0-9]{11}") && inputPhoneNumber.getText().length() == 11) {
						if(!Database.getInstance().searchSameData("phonenumber", inputPhoneNumber.getText())) {
							_phoneNumber = inputPhoneNumber.getText();
							phoneNumberError.setText(" ");
						}
						else {
							_phoneNumber = null;
							phoneNumberError.setForeground(Color.RED);
							phoneNumberError.setText("µî·ÏµÈ ¹øÈ£°¡ Á¸Àç ÇÕ´Ï´Ù");		
						}						
					}
					else {
						_phoneNumber = null;
						phoneNumberError.setForeground(Color.RED);
						phoneNumberError.setText("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù");						
					}
					
					_email = inputEmail.getText();
					
					if(birth.getText().matches("^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])") && birth.getText().length() == 6) {
						System.out.println("asdf");
						_birth = birth.getText();
						birthError.setText(" ");
					}
					else {
						_birth = null;
						birthError.setForeground(Color.RED);
						birthError.setText("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù");					
					}
					
					if(sex.getText().matches("[1-4]") && sex.getText().length() == 1) {
						_sex = sex.getText();
						sexError.setText(" ");
					}
					else {
						_sex = null;
						sexError.setForeground(Color.RED);
						sexError.setText("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù");		
					}
					
					if(InputAdress.getText().matches("[°¡-ÆR]{2,4}½Ã\\s[°¡-ÆR]{1,3}±¸\\s[°¡-ÆR0-9]{1,10}")) {
						_adress = InputAdress.getText();		
						adressError.setText(" ");
					}
					else {
						_adress = null;
						adressError.setForeground(Color.RED);
						adressError.setText("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù");		
					}
					
					if(_id != null && _password != null && _phoneNumber != null && _birth != null && _sex != null && _adress != null) {
						
						Database.getInstance().createNewAccount(_id, _password, _phoneNumber, _email,  _birth,  _sex,  _adress);
						frame.change("LogIn");
					}					
				}else {
					paaswordConfirmError.setForeground(Color.RED);
					paaswordConfirmError.setText("ºñ¹Ğ¹øÈ£°¡ ´Ù¸¨´Ï´Ù");	
				}			
			}

			public void mouseEntered(MouseEvent e) {
				frame.playButtonSound("src/buttonSound.wav");
				JLabel j = (JLabel) e.getSource();
				j.setText(" ");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setText("");
			}			
		});
	}
	
	private void initializeSocialSecurityNumber() {
		socialSecurityNumber = new JPanel();	
		
		socialSecurityNumber.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		birth = new RoundedJTextField(15);
		Hyphen = new JLabel("-");
		sex = new RoundedJTextField(15);
		securityNumber  = new JLabel("¡Ü¡Ü¡Ü¡Ü¡Ü¡Ü¡Ü");
		
		birth.setColumns(14);
		sex.setColumns(2);
		
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
		if(order != 15)component.setBounds(Constants.ACCOUNTINPUT_X,Constants.ACCOUNTINPUT_Y + order*Constants.ACCOUNTINPUT_GAP,Constants.ACCOUNTINPUT_WIDTH, Constants.ACCOUNTINPUT_HEIGHT);
		else component.setBounds(Constants.ACCOUNTINPUT_X-10,Constants.ACCOUNTINPUT_Y + order*Constants.ACCOUNTINPUT_GAP - 10,Constants.ACCOUNTINPUT_WIDTH+10, Constants.ACCOUNTINPUT_HEIGHT+10);
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
