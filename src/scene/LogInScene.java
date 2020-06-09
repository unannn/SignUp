package scene;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import utitlity.Constants;

public class LogInScene extends JPanel {
	
	private JLabel title;
	private JLabel welcome;
	
	private JPanel buttonPanel;
	private JButton logOut;
	private JButton modyfingMyInfo;
	private JButton accountDeletion;
	
	public LogInScene(SignUpFrame flame) {
		title = new JLabel(Constants.TOP_TITLE);
		welcome = new JLabel(Constants.WELCOME);
		
		buttonPanel = new JPanel();
		logOut = new JButton("�α׾ƿ�");
		modyfingMyInfo = new JButton("�� ���� ����");
		accountDeletion = new JButton("���� ����");
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(logOut);
		buttonPanel.add(modyfingMyInfo);
		buttonPanel.add(accountDeletion);
		buttonPanel.setBackground(new Color(181, 230, 29));
		setLayout(new BorderLayout());		
		
		//Ÿ��Ʋ ����Ʈ
		title.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				flame.change("LogInScene");
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
		
		logOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				flame.change("LogIn");
			}
			
		});
		
		
		this.setBackground(new Color(181, 230, 29));
		
		add(title, BorderLayout.BEFORE_FIRST_LINE);
		add(welcome, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
	}
}
