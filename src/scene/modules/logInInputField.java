package scene.modules;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import scene.SignUpFrame;
import utitlity.Constants;

public class LogInInputField extends JPanel{
	
	public JTextField inputID;
	public JPasswordField inputPassword;
	public JButton logInButton;
	public JLabel errorSign;
	
	
	public JPanel serchingAndCreatingAccount;
	public JButton searchByID;
	public JButton searchByPassword;
	public JButton AccountCreation;
	
	public LogInInputField(SignUpFrame frame) {		
		
		setLayout(null);
		//���̵�� ��й�ȣ, �α��� ��ư ����
		inputID = new JTextField("���̵� �Է��ϼ���");
		inputPassword = new JPasswordField();
		errorSign = new JLabel();
		logInButton = new JButton("�α���");
		
		
		//����ã��, ȸ������ ��ư �гΰ� ��ư ����
		serchingAndCreatingAccount = new JPanel();
		searchByID = new JButton("���̵�� ã��");
		searchByPassword = new JButton("��й�ȣ�� ã��");
		AccountCreation = new JButton("ȸ������");	
		
	    //PasswordField ��Ʈ �ؽ�Ʈ ����
		char passwordChar = inputPassword.getEchoChar();
		inputPassword.setEchoChar ((char) 0);
		inputPassword.setText("��й�ȣ�� �Է��ϼ���");
		
		//�̺�Ʈ ó��
		inputID.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {				
				if(inputID.getText().equals("���̵� �Է��ϼ���"))inputID.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(inputID.getText().equals("")) inputID.setText("���̵� �Է��ϼ���");
			}
			
		});
		
		inputPassword.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(inputPassword.getText().equals("��й�ȣ�� �Է��ϼ���")) {
					inputPassword.setText("");
					inputPassword.setEchoChar(passwordChar);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(inputPassword.getText().equals("")) {
					inputPassword.setEchoChar ((char) 0);
					inputPassword.setText("��й�ȣ�� �Է��ϼ���");
				}
			}
			
		});
		
		AccountCreation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JButton button = (JButton)e.getSource();
				frame.change("SignUp");
			}
			
		});
		
		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				boolean canLogIn = Database.getInstance().findIdAndPassword(inputID.getText(), inputPassword.getText().toString());
				if(canLogIn) {
					frame.change("LogInScene");
				}
				else {
					errorSign.setText("�������� ���� ���̵��̰ų�, �߸��� ��й�ȣ�Դϴ�.");
					errorSign.setBackground(Color.BLUE);
					errorSign.setForeground(Color.RED);
					//frame.change("LogIn");
				}
			}			
		});
		
		//��Ŀ���� �ȳ���ǳ�� ����
		
		inputID.setToolTipText("���̵� �Է��ϼ���");
		inputPassword.setToolTipText("��й�ȣ�� �Է��ϼ���");
		
		
		//�г� ����
		serchingAndCreatingAccount.setLayout(new FlowLayout());
		serchingAndCreatingAccount.add(searchByID);
		serchingAndCreatingAccount.add(searchByPassword);
		serchingAndCreatingAccount.add(AccountCreation);
		serchingAndCreatingAccount.setBackground(new Color(181,230,29));
		
		this.setBackground(new Color(181,230,29));
		
		//������Ʈ ��ġ 
		inputID.setBounds(Constants.COMPONENT_X,Constants.COMPONENT_INIT_Y,Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		inputPassword.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y + Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		errorSign.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  + 2*Constants.COMPONENT_GAP-30, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		logInButton.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  + 3*Constants.COMPONENT_GAP-30, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		serchingAndCreatingAccount.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  +4*Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
			
		
		//���ڼ� ����		
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
