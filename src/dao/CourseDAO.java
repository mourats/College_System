package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Course;

/**
 * Data Access Object of the Course object. This class responsible for interact
 * to the table of course. CRUD interactions.
 *
 * @author thiagomoura21
 */
public class CourseDAO {

	private Connection connection;

	/**
	 * Constructor of CourseDAO get the connection with DataBase MySQL.
	 */
	public CourseDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	/**
	 * Method responsible for entering a new course in the course table.
	 * 
	 * @param courseName
	 *            Name of the new course.
	 */
	public void insert(String courseName) {

		try {
			String sql = "INSERT INTO TB_COURSE " + "(NAME)" + " VALUES (?);";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, courseName);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method responsible for returning a course object with the given id.
	 * 
	 * @param idCourse
	 *            Course ID will be search.
	 * 
	 * @return Return a object course.
	 */
	public Course getCourseById(int idCourse) {

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_COURSE WHERE ID=" + idCourse + ";");

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				return makeCourse(response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Method responsible for returning a list of all courses in the course table
	 * 
	 * @return Return a list of the courses object.
	 */
	public List<Course> getAllCourses() {

		List<Course> result = new ArrayList<Course>();

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("SELECT * FROM TB_COURSE");

			ResultSet response = stmt.executeQuery();

			while (response.next()) {
				result.add(makeCourse(response));
			}

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 
	 * Private method responsible for setting up a course from a resultSet.
	 * 
	 * @param response
	 *            One resultSet of the search.
	 * @return Return a object course.
	 * @throws SQLException
	 */
	private Course makeCourse(ResultSet response) throws SQLException {

		Course course = new Course();
		course.setId(response.getInt("ID"));
		course.setName(response.getString("NAME"));

		return course;
	}

	/**
	 * Method that delete a course in tb course.
	 * 
	 * @param idCourse
	 *            Course id that has been deleted
	 */
	public void deleteCourse(int idCourse) {
		try {
			String sql = "DELETE FROM TB_COURSE" + " WHERE ID =" + idCourse + ";";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
