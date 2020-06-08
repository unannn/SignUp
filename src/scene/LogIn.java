package scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utitlity.Constants;

public class LogIn extends JPanel {

	private JLabel title;
	private scene.modules.LogInInputField inputField;

	public LogIn(SignUpFrame flame) {
		title = new JLabel(Constants.TOP_TITLE);
		inputField = new scene.modules.LogInInputField(flame);
		setLayout(new BorderLayout());		
		
		//타이틀 이펙트
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

		this.setBackground(new Color(181, 230, 29));

		add(title, BorderLayout.BEFORE_FIRST_LINE);
		add(inputField, BorderLayout.CENTER);
	}

}
