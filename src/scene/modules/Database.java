package scene.modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utitlity.Constants;

public class Database {
	private static Database instance; // 싱글턴 구현

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public Database() {
	}

	public boolean findIdAndPassword(String id, String password) {
		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			resultSet = statement.executeQuery(
					"select id,password from account where id='" + id + "' AND password='" + password + "'");

			if (statement
					.execute("select id,password from account where id='" + id + "' AND password='" + password + "'")) {

				resultSet = statement.getResultSet();

				int count = 0;

				while (resultSet.next()) {
					++count;
				}

				if (count == 1)
					return true;
				else
					return false;
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

	public void createNewAccount(String id, String password, String phoneNumber, String email, String birth, String sex,
			String adress) {
		try {
			PreparedStatement pstmt = null;

			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			String SQL = "insert into account(id, password, phoneNumber, email, birth,sex, adress) values(?, ?, ?, ?, ?, ?, ?)";

			pstmt = connection.prepareStatement(SQL);

			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, phoneNumber);
			pstmt.setString(4, email);
			pstmt.setString(5, birth);
			pstmt.setString(6, sex);
			pstmt.setString(7, adress);

			int r = pstmt.executeUpdate();
			System.out.println("변경된 row : " + r);

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());

			System.out.println("SQLState: " + sqex.getSQLState());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String findMyIdByPhoneNumber(String phoneNumber) {
		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			resultSet = statement.executeQuery("select id from account where phonenumber ='" + phoneNumber + "'");

			if (statement.execute("select id from account where phonenumber ='" + phoneNumber + "'")) {

				resultSet = statement.getResultSet();

				String str = null;

				while (resultSet.next()) {
					str = resultSet.getNString("id");
					System.out.println(str);
				}
				if (str != null)
					return str;
			}

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());

			System.out.println("SQLState: " + sqex.getSQLState());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean searchSameData(String element, String string) {
		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			resultSet = statement.executeQuery("select id from account where " + element + " ='" + string + "'");

			if (statement.execute("select id from account where " + element + " ='" + string + "'")) {

				resultSet = statement.getResultSet();

				int count = 0;

				while (resultSet.next()) {
					count++;
				}
				if (count > 0)
					return true;
				else
					return false;
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

	public int deleteAccount(String id, String password) {

		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			String SQL = "delete from account where id = ? AND password = ?";

			PreparedStatement pstmt = connection.prepareStatement(SQL);

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			int r = pstmt.executeUpdate();

			return r;

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
			return 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public String[] bringModifyingInfo(String id) {

		String[] modifyingInfo = new String[3];

		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			resultSet = statement.executeQuery("select phonenumber, email, adress from account where id ='" + id + "'");

			if (statement.execute("select phonenumber, email, adress from account where id ='" + id + "'")) {

				resultSet = statement.getResultSet();

				if (resultSet.next()) {
					modifyingInfo[0] = resultSet.getString("phonenumber");
					modifyingInfo[1] = resultSet.getString("email");
					modifyingInfo[2] = resultSet.getString("adress");
				}
			}

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());

			System.out.println("SQLState: " + sqex.getSQLState());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modifyingInfo;
	}

	public void updateModifyingInfo(String id, String phoneNumber, String email, String adress) {

		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			if (statement.execute("update account set phonenumber = '" + phoneNumber + "', email = '" + email
					+ "', adress = '" + adress + "' where id ='" + id + "'")) {

				resultSet = statement.getResultSet();

				if (resultSet.next()) {
					System.out.println("update sucess!!");
				}
			}

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());

			System.out.println("SQLState: " + sqex.getSQLState());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean searchSamePhoneNumber(String id, String phoneNumber) {
		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			resultSet = statement.executeQuery("select id from account where id <>'" + id + "' AND phonenumber = '"+phoneNumber+"'");

			if (statement.execute("select id from account where id <>'" + id + "' AND phonenumber = '"+phoneNumber+"'")) {

				resultSet = statement.getResultSet();

				int count = 0;

				while (resultSet.next()) {
					count++;
				}
				if (count > 0)
					return true;
				else
					return false;
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
	
	public String findMyPasswordByPhoneNumber(String id, String phoneNumber, String email) {
		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);

			java.sql.Statement statement = null;

			ResultSet resultSet = null;

			statement = connection.createStatement();

			statement.execute("USE signup");

			resultSet = statement.executeQuery("select password from account where id = '"+id+"' AND phonenumber ='" + phoneNumber + "' AND email = '"+ email +"'");

			if (statement.execute("select password from account where id = '"+id+"' AND phonenumber = '" + phoneNumber + "' AND email = '"+ email +"'")) {

				resultSet = statement.getResultSet();

				String str = null;

				while (resultSet.next()) {
					str = resultSet.getNString("password");
					System.out.println(str);
				}
				
				return str;
			}

		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());

			System.out.println("SQLState: " + sqex.getSQLState());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
