package scene;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import scene.modules.Database;


public class SignUpFrame extends JFrame {
	
	public Database database;
	
	public LogIn logIn;
	public SignUp signUp;
	public LogInScene logInScene;
	public SearchingID searchingID;
	public String nowLogInID;
	public AccountDeletion accountDeletion;
	public ModifyingMyInfo modifyingMyInfo;
	public SearchingPassword searchingPassword;
	public SignUpFrame(){
		nowLogInID = null;
		logIn = new LogIn(this);
		setLayout(new BorderLayout());
				
		add(logIn,BorderLayout.CENTER);
			
		setVisible(true);
		setSize(new Dimension(540,800));
		setResizable(false);
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
		else if(panelName.equals("SearchingID")){
			searchingID = new SearchingID(this);
			
			getContentPane().removeAll();
			getContentPane().add(searchingID);
			revalidate();
			repaint();
		}
		else if(panelName.equals("AccountDeletion")){
			accountDeletion = new AccountDeletion(this);
			
			getContentPane().removeAll();
			getContentPane().add(accountDeletion);
			revalidate();
			repaint();
		}
		else if(panelName.equals("ModifyingMyInfo")){
			modifyingMyInfo = new ModifyingMyInfo(this);
			
			getContentPane().removeAll();
			getContentPane().add(modifyingMyInfo);
			revalidate();
			repaint();
		}
		else if(panelName.equals("SearchingPassword")){
			searchingPassword = new SearchingPassword(this);
			
			getContentPane().removeAll();
			getContentPane().add(searchingPassword);
			revalidate();
			repaint();
		}
	}
	public void playButtonSound(String fileName) {
		 try
	        {
			 	System.out.println(System.getProperty("user.dir"));
	            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
	            Clip clip = AudioSystem.getClip();
	            clip.stop();
	            clip.open(ais);
	            clip.start();
	        }
	        catch (Exception ex)
	        {
	        	System.out.println(ex);
	        }
	}
}
