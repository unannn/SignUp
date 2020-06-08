package scene;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import scene.modules.Database;


public class SignUpFrame extends JFrame {
	
	public Database database;
	
	public LogIn logIn;
	public SignUp signUp;
	public LogInScene logInScene;
	
	
	public SignUpFrame(){
		//database = new Database();
		
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
		else if(panelName.equals("SignUp")){
			signUp = new SignUp(this);
			
			getContentPane().removeAll();
           

			getContentPane().add(signUp);
			revalidate();
			repaint();
		}
		else if(panelName.equals("LogInScene")){
			logInScene = new LogInScene(this);
			
			getContentPane().removeAll();
           

			getContentPane().add(logInScene);
			revalidate();
			repaint();
		}
	}
}
