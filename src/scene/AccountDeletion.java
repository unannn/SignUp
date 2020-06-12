package scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import scene.modules.Database;
import utitlity.Constants;
import scene.modules.*;

public class AccountDeletion extends JPanel{
	private JLabel title;
		
	private JPanel inputPanel;
	private JLabel password;
	private RoundedPasswordField passwordInput;
	private JLabel errorMessage;
	private JLabel deletionButton;
	private JLabel bottomBanner;
	
	public AccountDeletion(SignUpFrame frame) {
		
		title = new JLabel(Constants.TOP_TITLE);
		inputPanel = new JPanel();
		password = new JLabel("비밀번호 입력 : ");
		passwordInput = new RoundedPasswordField(15);
		errorMessage = new JLabel(" ");
		deletionButton = new JLabel(Constants.BIG_DELETE_ACCOUNT);
		bottomBanner = new JLabel(Constants.BOTTOM_BANNER);
		inputPanel.setLayout(null);
		inputPanel.add(password);
		inputPanel.add(passwordInput);
		inputPanel.add(errorMessage);
		inputPanel.add(deletionButton);
		inputPanel.setBackground(new Color(181, 230, 29));
		setLayout(new BorderLayout());		
		
		password.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y, 100, Constants.COMPONENT_HEIGHT);
		passwordInput.setBounds(180, Constants.COMPONENT_INIT_Y, 250, Constants.COMPONENT_HEIGHT);
		errorMessage.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y + Constants.COMPONENT_GAP/2, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		deletionButton.setBounds(Constants.COMPONENT_X, Constants.COMPONENT_INIT_Y+ Constants.COMPONENT_GAP +10, Constants.COMPONENT_WIDTH, Constants.COMPONENT_HEIGHT);
		
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

		//버튼 이벤트
		deletionButton.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				if(Database.getInstance().deleteAccount(frame.nowLogInID, passwordInput.getText()) == 1) {
					frame.nowLogInID = null;
					frame.change("LogIn");
				}
				else {
					errorMessage.setForeground(Color.RED);
					errorMessage.setText("비밀번호가 틀렸습니다");
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
			
		
		this.setBackground(new Color(181, 230, 29));
		
		add(title, BorderLayout.BEFORE_FIRST_LINE);
		add(inputPanel, BorderLayout.CENTER);
		add(bottomBanner,BorderLayout.AFTER_LAST_LINE);
	}
}
