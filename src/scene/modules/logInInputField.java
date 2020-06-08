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
		//���̵�� ��й�ȣ, �α��� ��ư ����
		inputID = new JTextField("���̵� �Է��ϼ���");
		inputPassword = new JTextField("��й�ȣ�� �Է��ϼ���");
		logInButton = new JButton("�α���");
		
		
		//����ã��, ȸ������ ��ư �гΰ� ��ư ����
		serchingAndCreatingAccount = new JPanel();
		searchByID = new JButton("���̵�� ã��");
		searchByPassword = new JButton("��й�ȣ�� ã��");
		AccountCreation = new JButton("ȸ������");	
		
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
				if(inputPassword.getText().equals("��й�ȣ�� �Է��ϼ���"))inputPassword.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(inputPassword.getText().equals("")) inputPassword.setText("��й�ȣ�� �Է��ϼ���");
			}
			
		});
		
		
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
		logInButton.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  + 2*Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		serchingAndCreatingAccount.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y  +3*Constants.COMPONENT_GAP, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
				
		
		add(inputID);
		add(inputPassword);
		add(logInButton);
		add(serchingAndCreatingAccount);

	}
	
}
