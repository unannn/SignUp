package scene.modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private static Database instance;  //½Ì±ÛÅÏ ±¸Çö
	
	public static Database getInstance() {
        if (instance == null) { instance = new Database();}
        return instance;
    }
	
	public Database(){
//		try {
//			Connection connection = null;
//
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			connection = DriverManager.getConnection("jdbc:mysql://localhost/signup?characterEncoding=UTF-8&serverTimezone=UTC", "root", "0000");
//
//			java.sql.Statement statement = null;
//
//			ResultSet resultSet = null;
//
//			statement = connection.createStatement();
//
//			statement.execute("USE signup");
//			
//			resultSet = statement.executeQuery("select * from account");
//
//			if (statement.execute("select * from account")) {
//
//				resultSet = statement.getResultSet();
//			}
//
//			while (resultSet.next()) {
//
//				String str = resultSet.getNString("id");
//
//				System.out.println(str);
//
//			}
//
//		} catch (SQLException sqex) {
//
//			System.out.println("SQLException: " + sqex.getMessage());
//
//			System.out.println("SQLState: " + sqex.getSQLState());
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public boolean findIdAndPassword(String id,String password) {		
		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost/signup?characterEncoding=UTF-8&serverTimezone=UTC", "root", "0000");

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");
			
			resultSet = statement.executeQuery("select id,password from account where id='" +id+"' AND password='"+password+"'");

			if (statement.execute("select id,password from account where id='" +id+"' AND password='"+password+"'")) {

				resultSet = statement.getResultSet();
				
				int count = 0;
				
				while(resultSet.next()) {
					++count;					
				}
				System.out.println(count + " " + id + " " + password);
				if(count == 1)return true;
				else return false;
			}

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());

			System.out.println("SQLState: " + sqex.getSQLState());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
