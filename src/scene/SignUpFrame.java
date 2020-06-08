package scene;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class SignUpFrame extends JFrame {
	
	public LogIn logIn;
	public SignUp signUp;
	
	public SignUpFrame(){
		
		logIn = new LogIn(this);
		//signUp = new SignUp();
		setLayout(new BorderLayout());
				
		add(logIn,BorderLayout.CENTER);
			
		setVisible(true);
		setSize(new Dimension(540,800));
		this.setMinimumSize(new Dimension(540,800));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void change(String panelName){
		
		if(panelName.equals("LogIn")) {
			logIn = new LogIn(this);	
			
			getContentPane().removeAll();
			getContentPane().add(logIn);
			revalidate();
			repaint();
		}
		else {
			signUp = new SignUp(this);
			
			getContentPane().removeAll();
           

			getContentPane().add(signUp);
			revalidate();
			repaint();
		}
	}
}
