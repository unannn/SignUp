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

import scene.modules.*;

public class SearchingPassword extends JPanel {
	
	private JLabel title;
	
	private JPanel inputPanel;
	private JLabel id;
	private JLabel phoneNumber;
	private JLabel email;
	private RoundedJTextField inputID;
	private RoundedJTextField inputPhoneNumber;
	private RoundedJTextField inputEmail;
	private JLabel errorMessage;
	private JLabel search;
	private JLabel bottomBanner;
	
	public SearchingPassword(SignUpFrame frame) {
		
		title = new JLabel(Constants.TOP_TITLE);
		
		inputPanel = new JPanel();
		id = new JLabel("아이디 : ");
		phoneNumber = new JLabel("휴대 번호 : ");
		email = new JLabel("이메일 : ");
		
		inputID = new RoundedJTextField(15);
		inputPhoneNumber = new RoundedJTextField(15);
		inputEmail = new RoundedJTextField(15);
		
		errorMessage = new JLabel(" ");
		search = new JLabel(Constants.BIG_FIND_PW);		
		bottomBanner = new JLabel(Constants.BOTTOM_BANNER);
		
		setLayout(new BorderLayout());		
		
		//타이틀 이펙트
		title.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.change("LogIn");
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
		search.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				String serchingId = Database.getInstance().findMyPasswordByPhoneNumber(inputID.getText(),inputPhoneNumber.getText(),inputEmail.getText());
				if(serchingId != null) {
					errorMessage.setForeground(Color.BLACK);
					errorMessage.setText("PW : " + serchingId);
				}
				else {
					errorMessage.setText("일치하는 계정이 없습니다");
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
						
		inputPanel.setLayout(null);
		
		id.setBounds(90, 100, 100, 40);
		inputID.setBounds(180, 100, 250, 40);
		phoneNumber.setBounds(90, 160, 100, 40);
		inputPhoneNumber.setBounds(180, 160, 250, 40);
		errorMessage.setBounds(180,255,350,40);
		email.setBounds(90, 220, 100, 40);
		inputEmail.setBounds(180, 220, 250, 40);
		search.setBounds(90, 280, 350, 40);
		
		errorMessage.setBackground(new Color(181, 230, 29));
		errorMessage.setForeground(Color.RED);
		inputPanel.setBackground(new Color(181, 230, 29));
		
		//입력개수제한
		limitCharcaterNumber(inputPhoneNumber,11);
		inputPanel.add(id);
		inputPanel.add(inputID);
		inputPanel.add(phoneNumber);
		inputPanel.add(inputPhoneNumber);
		inputPanel.add(errorMessage);
		inputPanel.add(email);
		inputPanel.add(inputEmail);
		inputPanel.add(search);
		
		this.setBackground(new Color(181, 230, 29));
		
		add(title, BorderLayout.BEFORE_FIRST_LINE);		
		add(inputPanel,BorderLayout.CENTER);
		add(bottomBanner,BorderLayout.AFTER_LAST_LINE);
		
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
