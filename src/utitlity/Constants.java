package utitlity;

import javax.swing.ImageIcon;

public class Constants {
	public static final ImageIcon TOP_TITLE = new ImageIcon("src/title2.png");
	public static final ImageIcon WELCOME = new ImageIcon("src/welcome.png");
	public static final ImageIcon LOGIN_BUTTON = new ImageIcon("src/logInButton.png");
	public static final ImageIcon BOTTOM_BANNER = new ImageIcon("src/bottomBanner.png");
	public static final ImageIcon BOTTOM_BANNER_SHORT = new ImageIcon("src/bottomBanner2.png");
	public static final ImageIcon SIGN_UP_SMALL = new ImageIcon("src/smallSignUp.png");
	public static final ImageIcon FIND_ID = new ImageIcon("src/findID.png");
	public static final ImageIcon FIND_PW = new ImageIcon("src/findPW.png");
	public static final ImageIcon SIGN_UP_SMALL_FOCUS = new ImageIcon("src/smallSignUpFocus.png");
	public static final ImageIcon FIND_ID_FOCUS = new ImageIcon("src/findIDFocus.png");
	public static final ImageIcon FIND_PW_FOCUS = new ImageIcon("src/findPWFocus.png");
	public static final ImageIcon SIGN_UP = new ImageIcon("src/SignUp.png");
	public static final ImageIcon BIG_FIND_ID = new ImageIcon("src/bigFindID.png");
	public static final ImageIcon BIG_FIND_PW = new ImageIcon("src/bigFindPW.png");

	public static final ImageIcon LOG_OUT = new ImageIcon("src/logOutButton.png");
	public static final ImageIcon MODIFYING = new ImageIcon("src/modifyingButton.png");
	public static final ImageIcon DELETE_ACCOUNT = new ImageIcon("src/deleteAccountButton.png");

	public static final ImageIcon LOG_OUT_FOCUS = new ImageIcon("src/logOutButtonFocus.png");
	public static final ImageIcon MODIFYING_FOCUS = new ImageIcon("src/modifyingButtonFocus.png");
	public static final ImageIcon DELETE_ACCOUNT_FOCUS = new ImageIcon("src/deleteAccountButtonFocus.png");
	
	public static final ImageIcon BIG_MODIFYING = new ImageIcon("src/bigModifyingButton.png");
	public static final ImageIcon BIG_DELETE_ACCOUNT = new ImageIcon("src/bigDeleteAccountButton.png");

	
	//로그인
	public static final int COMPONENT_WIDTH = 350;
	public static final int COMPONENT_HEIGHT = 40;
	public static final int COMPONENT_X = 90;
	public static final int COMPONENT_INIT_Y = 100;
	public static final int COMPONENT_GAP = 60;
	
	//회원가입
	public static final int ACCOUNTINPUT_WIDTH = 350;
	public static final int ACCOUNTINPUT_HEIGHT = 40;
	public static final int ACCOUNTINPUT_X = 90;
	public static final int ACCOUNTINPUT_Y = 0;
	public static final int ACCOUNTINPUT_GAP = 35;
	
	//글자수제한
	public static final int ID_LIMIT = 20;
	public static final int PASSWORD_LIMIT = 20;
	
	//using database
	public static final String URL = "jdbc:mysql://localhost/signup?characterEncoding=UTF-8&serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASSWORD = "0000";

}
