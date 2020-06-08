import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import scene.*;


public class SignUpFrame extends JFrame {
	
	public LogIn logIn = new LogIn();
	
	SignUpFrame(){
		
		setLayout(new BorderLayout());
				
		add(logIn,BorderLayout.CENTER);
		
	
		setVisible(true);
		setSize(new Dimension(540,800));
		this.setMinimumSize(new Dimension(540,800));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
