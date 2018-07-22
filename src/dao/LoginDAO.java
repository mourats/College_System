package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Login;

public class LoginDAO {

	private Connection connection;

	public LoginDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public boolean loginAdmin(Login login) {

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_LOGIN_ADMIN WHERE NAME_LOGIN = '" + login.getLoginName()
							+ "' and PASSWORD = '" + login.getPassword() + "'");

			ResultSet response = stmt.executeQuery();

			if (response.next())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginStudent(Login login) {

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_LOGIN_STUDENT WHERE NAME_LOGIN = '" + login.getLoginName()
							+ "' and PASSWORD = '" + login.getPassword() + "'");

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

	public void insertLogin(Login login) {

		try {
			String sql = "INSERT INTO TB_LOGIN_STUDENT " + "(ID, NAME_LOGIN, PASSWORD)" + " VALUES (?,?,?);";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, login.getIdStudent());
			stmt.setString(2, login.getLoginName());
			stmt.setString(3, login.getPassword());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

	public void updateLoginData(Login login) {
		try {
			String sql = "UPDATE TB_LOGIN_STUDENT SET " + "NAME_LOGIN=?, PASSWORD=?" + " WHERE ID =" + login.getIdStudent()
					+ ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, login.getLoginName());
			stmt.setString(2, login.getPassword());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
