package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Student;

/**
 * Data Access Object of the Student object. This class responsible for interact
 * to the table of student. CRUD interactions.
 * 
 * @author thiagomoura21
 */
public class StudentDAO {
	private Connection connection;

	/**
	 * Constructor of StudentDAO get the connection with DataBase MySQL.
	 */
	public StudentDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/**
	 * Method responsible for entering a new student in the course student.
	 * 
	 * @param student
	 *            Base object of the student.
	 */
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

	/**
	 * Private method responsible for setting up a student from a resultSet.
	 * 
	 * @param response
	 *            One resultSet of the search.
	 * @return Return a object student.
	 * @throws SQLException
	 */
	private Student makeStudent(ResultSet response) throws SQLException {

		Student student = new Student();
		student.setId(response.getInt("ID"));
		student.setName(response.getString("NAME"));
		student.setAddress(response.getString("ADDRESS"));
		student.setNationality(response.getString("NATIONALITY"));
		student.setCourse(response.getInt("ID_COURSE"));

		return student;
	}

	/**
	 * Method that delete a student in tb student.
	 * 
	 * @param id
	 *            Studentid that has been deleted.
	 */
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

	/**
	 * Method responsible for returning a list of all student in the student table.
	 * 
	 * @return Return a list of the student object.
	 */
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

	/**
	 * Method responsible for setting the new course that student has been.
	 * registered.
	 * 
	 * @param idStudent
	 *            Student ID will be the course resgistered.
	 * @param idCourse
	 *            ID of the course.
	 */
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

	/**
	 * Method responsible for returning a list of all student are in a determined
	 * course in the student table.
	 * 
	 * @param idCourse
	 *            ID of the course.
	 * @return Return a list of the student object.
	 */
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

	/**
	 * Method responsible for doing a search for a student by name.
	 * 
	 * @param nameStudent
	 *            Name of the student, in string.
	 * 
	 * @return Return a object student. If this student does not exist, return null.
	 */
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

	/**
	 * Method responsible for doing a search for a student by ID.
	 * 
	 * @param idStudent
	 *            Name of the student, in string.
	 * 
	 * @return Return a object student. If this student does not exist, return null.
	 */
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

	/**
	 * 
	 * Method responsible for performing an update on an existing student in the
	 * student table.
	 * 
	 * @param student
	 *            Object student are the base of the update.
	 */
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

	/**
	 * 
	 * Method responsible for removing the id from the course that is stored in a
	 * student.This happens when a course is removed from the system;
	 * 
	 * @param idCourse
	 *            Course id that has been deleted of the students.
	 */
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
}
