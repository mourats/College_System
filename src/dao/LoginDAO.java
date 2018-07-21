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

}
