package scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utitlity.Constants;

public class LogInScene extends JPanel {
	
	private JLabel title;
	private JLabel welcome;
	public LogInScene(SignUpFrame flame) {
		title = new JLabel(Constants.TOP_TITLE);
		welcome = new JLabel(Constants.WELCOME);
		
		setLayout(new BorderLayout());		
		
		//타이틀 이펙트
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

		this.setBackground(new Color(181, 230, 29));

		add(title, BorderLayout.BEFORE_FIRST_LINE);
		add(welcome, BorderLayout.CENTER);
	}
}
