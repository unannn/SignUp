package scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utitlity.Constants;

public class LogIn extends JPanel{
	
	private JLabel title;
	private scene.modules.logInInputField inputField;
	public LogIn(){
		title = new JLabel(Constants.TOP_TITLE);
		inputField =  new scene.modules.logInInputField();
		setLayout(new BorderLayout());		

		 this.setBackground(new Color(181,230,29));
		 
		 this.requestFocusInWindow(true);
		 
		 add(title,BorderLayout.BEFORE_FIRST_LINE);
		 add(inputField,BorderLayout.CENTER);		

	}
}
