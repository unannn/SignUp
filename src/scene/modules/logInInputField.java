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

		//���̵�� ��й�ȣ, �α��� ��ư ����
		inputID = new JTextField("���̵� �Է��ϼ���");
		inputPassword = new JTextField("��й�ȣ�� �Է��ϼ���");
		logInButton = new JButton("�α���");
		
		
		//����ã��, ȸ������ ��ư �гΰ� ��ư ����
		serchingAndCreatingAccount = new JPanel();
		searchByID = new JButton("���̵�� ã��");
		searchByPassword = new JButton("��й�ȣ�� ã��");
		AccountCreation = new JButton("ȸ������");	
		
		//��ġ
		inputID.setBounds(this.getX(), 10, 200, 40);
		inputPassword.setBounds(this.getWidth(), 60, 200, 40);
		logInButton.setBounds(this.getWidth(), 110 , 200, 40);
		serchingAndCreatingAccount.setBounds(10, 160, 200, 40);
		
		//�г� ����
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
