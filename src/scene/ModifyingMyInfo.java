package scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utitlity.Constants;

//회원가입
public class ModifyingMyInfo extends JPanel {
	
	private JLabel title;
	private scene.modules.ModifyingInputField inputField;
	private JLabel bottomBanner;
	
	public ModifyingMyInfo(SignUpFrame frame) {
		title = new JLabel(Constants.TOP_TITLE);
		inputField =  new scene.modules.ModifyingInputField(frame);
		bottomBanner = new JLabel(Constants.BOTTOM_BANNER);
		
		setLayout(new BorderLayout());		
		
		//타이틀 이펙트
		title.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.change("LogInScene");
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

		this.setBackground(new Color(181, 230, 29));

		add(title,BorderLayout.BEFORE_FIRST_LINE);		
		add(inputField,BorderLayout.CENTER);
		add(bottomBanner,BorderLayout.AFTER_LAST_LINE);
	}
}
