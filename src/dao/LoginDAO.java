package dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Login;

/**
 * Data Access Object of the Login object. This class responsible for interact to the
 * tables of login (student login and admin login). CRUD interactions.
 *
 * @author thiagomoura21
 */
public class LoginDAO {

	private Connection connection;

	/**
	 * Constructor of LoginDAO get the connection with DataBase MySQL.
	 */
	public LoginDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/**
	 * Method responsible for logging in to an admin. If the logged in login exists
	 * in the tb login admin table, it returns true, if not false.
	 * 
	 * @param login
	 *            Object login will be verify.
	 * 
	 * @return Return a boolean with the result of the search.
	 */
	public boolean loginAdmin(Login login) {

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_LOGIN_ADMIN WHERE NAME_LOGIN = '" + login.getLoginName()
							+ "' and PASSWORD = '" + encryptPassword(login.getPassword()) + "'");

			ResultSet response = stmt.executeQuery();

			if (response.next())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Method responsible for logging in to a student. If the logged in login exists
	 * in the tb login student table, it returns true, if not false.
	 * 
	 * @param login
	 *            Object login will be verify.
	 * 
	 * @return Return a boolean with the result of the search.
	 */
	public boolean loginStudent(Login login) {

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_LOGIN_STUDENT WHERE NAME_LOGIN = '" + login.getLoginName()
							+ "' and PASSWORD = '" + encryptPassword(login.getPassword()) + "'");

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				login.setIdStudent(response.getInt("ID"));
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Method that inserts a new login in tb login student. This method is always
	 * executed when a new student is enrolled in the system.
	 * 
	 * @param login
	 *            Object will be inserted;
	 */
	public void insertLogin(Login login) {

		try {
			String sql = "INSERT INTO TB_LOGIN_STUDENT " + "(ID, NAME_LOGIN, PASSWORD)" + " VALUES (?,?,?);";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, login.getIdStudent());
			stmt.setString(2, login.getLoginName());
			stmt.setString(3, encryptPassword(login.getPassword()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that delete a login in tb login student. This method is always
	 * executed when a student is deleted of the system.
	 * 
	 * @param id
	 *            Student id that has been deleted
	 */
	public void deleteLogin(int id) {

		try {
			String sql = "DELETE FROM TB_LOGIN_STUDENT" + " WHERE ID =" + id + ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that updates a student login to the system from the object login.
	 * 
	 * @param login
	 *            Base object for the update
	 */
	public void updateLoginData(Login login) {
		try {
			String sql = "UPDATE TB_LOGIN_STUDENT SET " + "NAME_LOGIN=?, PASSWORD=?" + " WHERE ID ="
					+ login.getIdStudent() + ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, login.getLoginName());
			stmt.setString(2, encryptPassword(login.getPassword()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that encrypts a password and returns what will be stored in the
	 * database or compared to what exists in the database.
	 * 
	 * @param password
	 *            Password will be encrypted.
	 * 
	 * @return Return the password encryted.
	 */
	private String encryptPassword(String password) {
		try {

			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			String hashPassword = hexString.toString();

			return hashPassword;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return password;
	}

	/**
	 * Method responsible for verifying the default admin login exists. If it does
	 * not exist, it calls the method responsible for creating it.
	 */
	public void initialLoginForAdmin() {
		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_LOGIN_ADMIN");

			ResultSet response = stmt.executeQuery();

			if (!response.next()) {
				insertLoginAdmin();
			}
			response.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method responsible for entering the default admin login for the project. This
	 * happens when the system is started for the first time.
	 */
	private void insertLoginAdmin() {
		try {
			String sql = "INSERT INTO TB_LOGIN_ADMIN " + "(NAME_LOGIN, PASSWORD)" + " VALUES (?,?);";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, "admin");
			stmt.setString(2, encryptPassword("admin123"));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
