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

	public void insert(Student student) {
		try {
			String sql = "INSERT INTO TB_STUDENT " + "(NAME,ADDRESS,NATIONALITY)" + " VALUES (?,?,?);";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getAddress());
			stmt.setString(3, student.getNationality());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public void deleteStudent(int id) {

		try {
			String sql = "DELETE FROM TB_STUDENT" + " WHERE ID =" + id + ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudents() {

		List<Student> result = new ArrayList<Student>();

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_STUDENT");

			ResultSet response = stmt.executeQuery();

			while (response.next()) {
				result.add(makeStudent(response));
			}
			response.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void setStudentInCourse(int idStudent, int idCourse) {

		try {
			String sql = "UPDATE TB_STUDENT SET " + "ID_COURSE= " + idCourse + " WHERE ID =" + idStudent + ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> getStudentsInCourse(int idCourse) {

		List<Student> result = new ArrayList<Student>();

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_STUDENT WHERE ID_COURSE = " + idCourse);

			ResultSet response = stmt.executeQuery();

			while (response.next()) {
				result.add(makeStudent(response));
			}

			response.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Student getStudentByName(String nameStudent) {

		Student student = null;

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_STUDENT WHERE NAME = '" + nameStudent + "';");

			ResultSet response = stmt.executeQuery();

			if (response.next())
				student = makeStudent(response);

			stmt.close();
			response.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public Student getStudentById(int idStudent) {
		Student student = null;

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_STUDENT WHERE ID = " + idStudent + ";");

			ResultSet response = stmt.executeQuery();

			if (response.next())
				student = makeStudent(response);

			stmt.close();
			response.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void updateStudent(Student student) {

		try {
			String sql = "UPDATE TB_STUDENT SET " + "NAME=?, ADDRESS=?, NATIONALITY=?" + " WHERE ID =" + student.getId()
					+ ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getAddress());
			stmt.setString(3, student.getNationality());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCourseInStudents(int idCourse) {
		try {
			String sql = "UPDATE TB_STUDENT SET " + "ID_COURSE=NULL" + " WHERE ID_COURSE =" + idCourse + ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean existStudent(int idStudent) {
		return getStudentById(idStudent) != null;
	}
}
