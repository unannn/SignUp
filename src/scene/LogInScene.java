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
	private JLabel logOut;
	private JLabel modyfingMyInfo;
	private JLabel accountDeletion;
	
	private JLabel bottomBanner;
	
	public LogInScene(SignUpFrame frame) {
		title = new JLabel(Constants.TOP_TITLE);
		welcome = new JLabel(Constants.WELCOME);
		
		buttonPanel = new JPanel();
		logOut = new JLabel(Constants.LOG_OUT);
		modyfingMyInfo = new JLabel(Constants.MODIFYING);
		accountDeletion = new JLabel(Constants.DELETE_ACCOUNT);
		bottomBanner = new JLabel(Constants.BOTTOM_BANNER);
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(logOut);
		buttonPanel.add(modyfingMyInfo);
		buttonPanel.add(accountDeletion);
		buttonPanel.setBackground(new Color(181, 230, 29));
		setLayout(new BorderLayout());		
		
		//타이틀 이펙트
		title.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.change("LogInScene");
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
		
		accountDeletion.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				frame.change("AccountDeletion");
			}

			public void mouseEntered(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.DELETE_ACCOUNT_FOCUS);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.DELETE_ACCOUNT);
			}
		});
		
		
		//버튼 이벤트
		
		logOut.addMouseListener(new MouseAdapter() {

			@Override			
			public void mouseClicked(MouseEvent e) {
				frame.nowLogInID = null;
				frame.change("LogIn");
			}

			public void mouseEntered(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.LOG_OUT_FOCUS);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.LOG_OUT);
			}
		});
		
		modyfingMyInfo.addMouseListener(new MouseAdapter() {

			@Override			
			public void mouseClicked(MouseEvent e) {
				frame.change("ModifyingMyInfo");
			}

			public void mouseEntered(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.MODIFYING_FOCUS);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel j = (JLabel) e.getSource();
				j.setIcon(Constants.MODIFYING);
			}
		});
		
		this.setBackground(new Color(181, 230, 29));
		
		add(title, BorderLayout.BEFORE_FIRST_LINE);
		add(welcome, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
		buttonPanel.add(bottomBanner);
	}
}
