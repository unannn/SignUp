package scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import utitlity.Constants;
import javax.swing.*;

import scene.modules.Database;

public class SearchingID extends JPanel {
	
	private JLabel title;
	
	private JPanel inputPanel;
	private JLabel phoneNumber;
	private JTextField inputPhoneNumber;
	private JLabel errorMessage;
	private JButton search;
	
	public SearchingID(SignUpFrame flame) {
		
		title = new JLabel(Constants.TOP_TITLE);	
		
		inputPanel = new JPanel();
		phoneNumber = new JLabel("�޴� ��ȣ : ");
		inputPhoneNumber = new JTextField();
		errorMessage = new JLabel(" ");
		search = new JButton("���̵� ã��");		
		
		setLayout(new BorderLayout());		
		
		//Ÿ��Ʋ ����Ʈ
		title.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				flame.change("LogIn");
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
		
		
		//��ư �̺�Ʈ
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String serchingId = Database.getInstance().findMyIdById(inputPhoneNumber.getText());
				if(serchingId != null) {
					errorMessage.setForeground(Color.BLACK);
					errorMessage.setText("ID : " + serchingId);
				}
				else {
					errorMessage.setText("���Ե� ���̵� �����ϴ�");
				}			
			}
			
		});
						
		inputPanel.setLayout(null);
		
		phoneNumber.setBounds(80, 100, 100, 40);
		inputPhoneNumber.setBounds(180, 100, 250, 40);
		errorMessage.setBounds(80,140,350,40);
		search.setBounds(80, 200, 350, 40);
		
		errorMessage.setBackground(new Color(181, 230, 29));
		errorMessage.setForeground(Color.RED);
		inputPanel.setBackground(new Color(181, 230, 29));
		
		//�Է°�������
		limitCharcaterNumber(inputPhoneNumber,11);
		
		inputPanel.add(phoneNumber);
		inputPanel.add(inputPhoneNumber);
		inputPanel.add(errorMessage);
		inputPanel.add(search);
		
		this.setBackground(new Color(181, 230, 29));
		
		add(title, BorderLayout.BEFORE_FIRST_LINE);		
		add(inputPanel,BorderLayout.CENTER);
		
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
