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

public class ModifyingInputField extends JPanel {
	
	public JLabel phoneNumber;
	public RoundedJTextField inputPhoneNumber;
	
	public JLabel email;
	public RoundedJTextField inputEmail;
		
	public JLabel adress;
	public RoundedJTextField inputAdress;
	
	
	public String _phoneNumber;
	public String _email;	
	public String _adress;
	
	
	public JLabel phoneNumberError;
	public JLabel adressError;
		
	public JLabel CreationButton;
	
	public String[] priviousInfo;
	
	public ModifyingInputField(SignUpFrame frame) {
		
		setLayout(null);
				
		phoneNumber  = new JLabel("ÈŞ´ëÆù ¹øÈ£('-'¾øÀÌ)");
		inputPhoneNumber = new RoundedJTextField(15);
		phoneNumberError = new JLabel(" ");
		
		email  = new JLabel("ÀÌ¸ŞÀÏ");
		inputEmail = new RoundedJTextField(15);
						
		adress  = new JLabel("ÁÖ¼Ò(¡Ü¡Ü½Ã ¡Ü¡Ü±¸ ¡Ü¡Ü¡Ü)");
		inputAdress = new RoundedJTextField(15);
		adressError = new JLabel(" ");
		
		CreationButton = new JLabel(Constants.BIG_MODIFYING);
		
		this.setBackground(new Color(181,230,29));
		
		priviousInfo = Database.getInstance().bringModifyingInfo(frame.nowLogInID);
		
		inputPhoneNumber.setText(priviousInfo[0]);
		inputEmail.setText(priviousInfo[1]);
		inputAdress.setText(priviousInfo[2]);
		//ÁÂÇ¥¼³Á¤
		
		locateComponent(phoneNumber,6);
		locateComponent(inputPhoneNumber,7);
		
		locateComponent(email,8);
		locateComponent(inputEmail,9);
	
		locateComponent(adress,12);
		locateComponent(inputAdress,13);
		
		locateComponent(CreationButton,15);
	
		phoneNumberError.setBounds(210, Constants.ACCOUNTINPUT_Y + 6*Constants.ACCOUNTINPUT_GAP, 190, 40);
		adressError.setBounds(250, Constants.ACCOUNTINPUT_Y + 12*Constants.ACCOUNTINPUT_GAP, 190, 40);
		
		
		//±ÛÀÚ¼ö Á¦ÇÑ
		limitCharcaterNumber(inputPhoneNumber,11);
		limitCharcaterNumber(inputEmail,40);		
		limitCharcaterNumber(inputAdress,40);

		add(phoneNumber);
		add(inputPhoneNumber);
		add(email);
		add(inputEmail);
	
		add(adress);
		add(inputAdress);		
		
		add(CreationButton);
		
		add(phoneNumberError);
		add(adressError);
		
		CreationButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pattern = "[0-9a-zA-Z]{2,20}";
			
					if(inputPhoneNumber.getText().matches("[0-9]{11}") && inputPhoneNumber.getText().length() == 11) {
						if(!Database.getInstance().searchSamePhoneNumber(frame.nowLogInID, inputPhoneNumber.getText())) {
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
									
					
					if(inputAdress.getText().matches("[°¡-ÆR]{2,4}½Ã\\s[°¡-ÆR]{1,3}±¸\\s[°¡-ÆR0-9]{1,10}")) {
						_adress = inputAdress.getText();		
						adressError.setText(" ");
					}
					else {
						_adress = null;
						adressError.setForeground(Color.RED);
						adressError.setText("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù");		
					}
					
					if(_phoneNumber != null && _adress != null) {
						System.out.println("asdf");
						Database.getInstance().updateModifyingInfo(frame.nowLogInID,_phoneNumber, _email,_adress);
						frame.change("LogInScene");
					}											
			}

			public void mouseEntered(MouseEvent e) {
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
