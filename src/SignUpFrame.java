import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import scene.*;


public class SignUpFrame extends JFrame {
	
	public LogIn logIn = new LogIn();
	
	SignUpFrame(){
		
		setLayout(new BorderLayout());
				
		add(logIn,BorderLayout.CENTER);
		//add(displayPanel,BorderLayout.BEFORE_FIRST_LINE);
		//add(buttonPanel,BorderLayout.CENTER);
	
		setVisible(true);
		setSize(new Dimension(540,800));
		//this.setMinimumSize(new Dimension(Constants.INIT_FRAME_WIDTH,Constants.INIT_FRAME_HEIGHT));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
