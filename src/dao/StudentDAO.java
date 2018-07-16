package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Login;
import entities.Student;

public class StudentDAO {
	private Connection connection;

	public StudentDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public int insert(Student student) {
		String sql = "INSERT INTO TB_STUDENT " + "(NAME,ADDRESS,NATIONALITY,NAME_LOGIN,PASSWORD)"
				+ " VALUES (?,?,?,?,?);";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getAddress());
			stmt.setString(3, student.getNationality());
			stmt.setString(4, student.getLogin().getLogin_name());
			stmt.setString(5, student.getLogin().getPassword());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return this.loginStudent(student.getLogin()).getId();

	}

	public Student getStudentById(int id) {

		PreparedStatement stmt;

		try {
			stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_STUDENT WHERE ID = " + id);

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				return makeStudent(response);
			}

			response.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Student makeStudent(ResultSet response) throws SQLException {

		Student student = new Student();
		student.setId(response.getInt("ID"));
		student.setName(response.getString("NAME"));
		student.setAddress(response.getString("ADDRESS"));
		student.setNationality(response.getString("NATIONALITY"));
		student.setLogin(new Login(response.getString("NAME_LOGIN"), response.getString("PASSWORD")));

		return student;
	}

	public Student loginStudent(Login login) {

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_STUDENT WHERE NAME_LOGIN = '"
					+ login.getLogin_name() + "' and PASSWORD = '" + login.getPassword() + "'");

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				return makeStudent(response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void updateStudent(Student student) {

		String sql = "UPDATE TB_STUDENT SET " + "NAME=?, ADDRESS=?, NATIONALITY=?, NAME_LOGIN=?, PASSWORD=?"
				+ " WHERE ID =" + student.getId() + ";";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getAddress());
			stmt.setString(3, student.getNationality());
			stmt.setString(4, student.getLogin().getLogin_name());
			stmt.setString(5, student.getLogin().getPassword());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deleteStudent(int id) {

		String sql = "DELETE FROM TB_STUDENT" + " WHERE ID =" + id + ";";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<String> getAllStudents() {

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_STUDENT");

			ResultSet response = stmt.executeQuery();

			List<String> result = new ArrayList<String>();

			while (response.next()) {
				result.add(makeStudent(response).toString());
			}
			response.close();
			stmt.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void setStudentInCourse(int idStudent, int idCourse) {

		String sql = "UPDATE TB_STUDENT SET " + "COURSE= " + idCourse + " WHERE ID =" + idStudent + ";";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void disconnect() throws SQLException {
		this.connection.close();
	}

	public List<String> getStudentsInCourse(int idCourse) {

		PreparedStatement stmt;

		try {
			stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_STUDENT WHERE COURSE = " + idCourse);

			ResultSet response = stmt.executeQuery();

			List<String> result = new ArrayList<String>();

			while (response.next()) {
				result.add(makeStudent(response).toString());
			}
			
			response.close();
			stmt.close();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

}
