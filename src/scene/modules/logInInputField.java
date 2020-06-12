package scene.modules;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import scene.SignUpFrame;
import utitlity.Constants;

public class LogInInputField extends JPanel{
	
	public RoundedJTextField inputID;
	public RoundedPasswordField inputPassword;
	public JLabel logInButton;
	public JLabel errorSign;
	
	
	public JPanel serchingAndCreatingAccount;
	public JLabel searchingID;
	public JLabel searchingPassword;
	public JLabel AccountCreation;
	
	public LogInInputField(SignUpFrame frame) {		
		
		setLayout(null);
		//아이디와 비밀번호, 로그인 버튼 생성
		inputID = new RoundedJTextField(15);
		inputPassword = new RoundedPasswordField(15);
		errorSign = new JLabel();
		logInButton = new JLabel(Constants.LOGIN_BUTTON);
		
		inputID.setText("아이디를 입력하세요");
		
		//계정찾기, 회원가입 버튼 패널과 버튼 생성
		serchingAndCreatingAccount = new JPanel();
		searchingID = new JLabel(Constants.FIND_ID);
		searchingPassword = new JLabel(Constants.FIND_PW);
		AccountCreation = new JLabel(Constants.SIGN_UP_SMALL);	
		
	    //PasswordField 고스트 텍스트 생성
		char passwordChar = inputPassword.getEchoChar();
		inputPassword.setEchoChar ((char) 0);
		inputPassword.setText("비밀번호를 입력하세요");
		
		//이벤트 처리
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
				if(inputPassword.getText().equals("비밀번호를 입력하세요")) {
					inputPassword.setText("");
					inputPassword.setEchoChar(passwordChar);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(inputPassword.getText().equals("")) {
					inputPassword.setEchoChar ((char) 0);
					inputPassword.setText("비밀번호를 입력하세요");
				}
			}			
		});
		inputPassword.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					boolean canLogIn = Database.getInstance().findIdAndPassword(inputID.getText(), inputPassword.getText().toString());
					if(canLogIn) {
						frame.nowLogInID = inputID.getText();
						frame.change("LogInScene");
					}
					else {
						errorSign.setText("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
						errorSign.setBackground(Color.BLUE);
						errorSign.setForeground(Color.RED);
						
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		AccountCreation.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				frame.change("SignUp");
			}

			public void mouseEntered(MouseEvent e) {
				frame.playButtonSound("src/beep.wav");

				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.SIGN_UP_SMALL_FOCUS);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.SIGN_UP_SMALL);
			}
		});
		
		logInButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean canLogIn = Database.getInstance().findIdAndPassword(inputID.getText(), inputPassword.getText().toString());
				if(canLogIn) {
					frame.nowLogInID = inputID.getText();
					frame.change("LogInScene");
				}
				else {
					errorSign.setText("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
					errorSign.setBackground(Color.BLUE);
					errorSign.setForeground(Color.RED);
					
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
	
		searchingID.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				frame.change("SearchingID");	
			}

			public void mouseEntered(MouseEvent e) {
				frame.playButtonSound("src/beep.wav");

				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.FIND_ID_FOCUS);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.FIND_ID);
			}
		});
		
		searchingPassword.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				frame.change("SearchingPassword");	
			}

			public void mouseEntered(MouseEvent e) {
				frame.playButtonSound("src/beep.wav");

				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.FIND_PW_FOCUS);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.FIND_PW);
			}
		});
		
		//포커스시 안내말풍선 생성		
		inputID.setToolTipText("아이디를 입력하세요");
		inputPassword.setToolTipText("비밀번호를 입력하세요");		
		
		//패널 설정
		serchingAndCreatingAccount.setLayout(new FlowLayout(FlowLayout.CENTER));
		serchingAndCreatingAccount.add(searchingID);
		serchingAndCreatingAccount.add(searchingPassword);
		serchingAndCreatingAccount.add(AccountCreation);
		serchingAndCreatingAccount.setBackground(new Color(181,230,29));
		
		this.setBackground(new Color(181,230,29));
		
		//컴포넌트 위치 
		inputID.setBounds(Constants.COMPONENT_X,Constants.COMPONENT_INIT_Y,Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		inputPassword.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y + Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		errorSign.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  + 2*Constants.COMPONENT_GAP-30, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		logInButton.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  + 3*Constants.COMPONENT_GAP-60, Constants.COMPONENT_WIDTH - 10, Constants.COMPONENT_HEIGHT+30);
		serchingAndCreatingAccount.setBounds(Constants.COMPONENT_X - 7, Constants.COMPONENT_INIT_Y  +4*Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
			
		
		//글자수 제한		
		limitCharcaterNumber(inputID,Constants.ID_LIMIT);
		limitCharcaterNumber(inputPassword,Constants.PASSWORD_LIMIT);
		
		add(inputID);
		add(inputPassword);
		add(logInButton);
		add(errorSign);
		add(serchingAndCreatingAccount);
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
