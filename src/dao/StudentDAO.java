package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Login;
import entities.Student;

public class StudentDAO {
	private Connection connection;

	public StudentDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void insert(Student student) throws SQLException {
		String sql = "INSERT INTO TB_STUDENT " + "(NAME,ADDRESS,NATIONALITY,NAME_LOGIN,PASSWORD)"
				+ " VALUES (?,?,?,?,?);";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getAddress());
			stmt.setString(3, student.getNationality());
			stmt.setString(4, student.getLogin().getLogin_name());
			stmt.setString(5, student.getLogin().getPassword());
			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private Student get(int id) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) this.connection
				.prepareStatement("SELECT * FROM TB_STUDENT WHERE ID = " + id);

		ResultSet response = stmt.executeQuery();
		Student student = null;
		String address, nationality, name, name_login, password;

		if (response.next()) {
			name = response.getString("NAME");
			address = response.getString("ADDRESS");
			nationality = response.getString("NATIONALITY");
			name_login = response.getString("NAME_LOGIN");
			password = response.getString("PASSWORD");

			student = new Student(id, name, address, nationality, name_login, password);
		}

		response.close();
		stmt.close();

		return student;

	}

	public Student LoginCliente(Login login) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection
				.prepareStatement("Select ID from TB_STUDENT WHERE NAME_LOGIN = '" + login.getLogin_name()
						+ "' and PASSWORD = '" + login.getPassword() + "'");

		ResultSet response = stmt.executeQuery();

		if (response.next()) {
			return this.get(response.getInt("ID"));
		}

		return null;
	}

	public void disconnect() throws SQLException {
		this.connection.close();
	}

}
