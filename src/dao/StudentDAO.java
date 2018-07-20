package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Student;

public class StudentDAO {
	private Connection connection;

	public StudentDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public int insert(Student student) throws SQLException {
		String sql = "INSERT INTO TB_STUDENT " + "(NAME,ADDRESS,NATIONALITY)" + " VALUES (?,?,?);";

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getAddress());
		stmt.setString(3, student.getNationality());

		stmt.execute();
		stmt.close();

		return getStudentIdByName(student.getName());
	}

	public int getStudentIdByName(String nameStudent) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) this.connection
				.prepareStatement("SELECT * FROM TB_STUDENT WHERE NAME = " + nameStudent);

		ResultSet response = stmt.executeQuery();
		stmt.close();

		if (response.next())
			return response.getInt("ID");
		else
			throw new RuntimeException();

	}

	public Student getStudentById(int id) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) this.connection
				.prepareStatement("SELECT * FROM TB_STUDENT WHERE ID = " + id);

		ResultSet response = stmt.executeQuery();
		stmt.close();

		if (response.next())
			return makeStudent(response);
		else
			throw new RuntimeException();
	}

	private Student makeStudent(ResultSet response) throws SQLException {

		Student student = new Student();
		student.setId(response.getInt("ID"));
		student.setName(response.getString("NAME"));
		student.setAddress(response.getString("ADDRESS"));
		student.setNationality(response.getString("NATIONALITY"));
		student.setCourse(response.getInt("ID_COURSE"));

		return student;
	}

	public void updateStudent(Student student) throws SQLException {

		String sql = "UPDATE TB_STUDENT SET " + "NAME=?, ADDRESS=?, NATIONALITY=?" + " WHERE ID =" + student.getId()
				+ ";";

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getAddress());
		stmt.setString(3, student.getNationality());

		stmt.execute();
		stmt.close();

	}

	public void deleteStudent(int id) throws SQLException {

		String sql = "DELETE FROM TB_STUDENT" + " WHERE ID =" + id + ";";

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

		stmt.execute();
		stmt.close();

	}

	public List<String> getAllStudents() throws SQLException {

		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_STUDENT");

		ResultSet response = stmt.executeQuery();

		List<String> result = new ArrayList<String>();

		while (response.next()) {
			result.add(makeStudent(response).toString());
		}
		response.close();
		stmt.close();

		return result;
	}

	public void setStudentInCourse(int idStudent, int idCourse) throws SQLException {

		String sql = "UPDATE TB_STUDENT SET " + "ID_COURSE= " + idCourse + " WHERE ID =" + idStudent + ";";

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();

	}

	public List<String> getStudentsInCourse(int idCourse) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) this.connection
				.prepareStatement("SELECT * FROM TB_STUDENT WHERE ID_COURSE = " + idCourse);

		ResultSet response = stmt.executeQuery();
		List<String> result = new ArrayList<String>();

		while (response.next()) {
			result.add(makeStudent(response).toString());
		}

		response.close();
		stmt.close();

		return result;

	}
}
