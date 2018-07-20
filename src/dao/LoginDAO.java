package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Login;
import entities.Student;

public class LoginDAO {
	
	private Connection connection;

	public LoginDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public String login(Login login) {
		return "";
	}
/*	
	public Student loginStudent(Login login) {

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_LOGIN_STUDENT WHERE NAME_LOGIN = '"
					+ login.getLoginName() + "' and PASSWORD = '" + login.getPassword() + "'");

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				return makeStudent(response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
*/


}
