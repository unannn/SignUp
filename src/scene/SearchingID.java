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

public class SearchingID extends JPanel {
	
	private JLabel title;
	
	private JPanel inputPanel;
	private JLabel phoneNumber;
	private RoundedJTextField inputPhoneNumber;
	private JLabel errorMessage;
	private JLabel search;
	private JLabel bottomBanner;
	public SearchingID(SignUpFrame frame) {
		
		title = new JLabel(Constants.TOP_TITLE);	
		
		inputPanel = new JPanel();
		phoneNumber = new JLabel("휴대 번호 : ");
		inputPhoneNumber = new RoundedJTextField(15);
		errorMessage = new JLabel(" ");
		search = new JLabel(Constants.BIG_FIND_ID);		
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
				String serchingId = Database.getInstance().findMyIdByPhoneNumber(inputPhoneNumber.getText());
				if(serchingId != null) {
					errorMessage.setForeground(Color.BLACK);
					errorMessage.setText("ID : " + serchingId);
				}
				else {
					errorMessage.setText("가입된 아이디가 없습니다");
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
		
		phoneNumber.setBounds(90, 100, 100, 40);
		inputPhoneNumber.setBounds(180, 100, 250, 40);
		errorMessage.setBounds(90,140,350,40);
		search.setBounds(90, 200, 350, 40);
		
		errorMessage.setBackground(new Color(181, 230, 29));
		errorMessage.setForeground(Color.RED);
		inputPanel.setBackground(new Color(181, 230, 29));
		
		//입력개수제한
		limitCharcaterNumber(inputPhoneNumber,11);
		
		inputPanel.add(phoneNumber);
		inputPanel.add(inputPhoneNumber);
		inputPanel.add(errorMessage);
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
