package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import entities.Course;

public class CourseDAO {

	private Connection connection;

	public CourseDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

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

	public String getCourseById(int idCourse) {

		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) this.connection
					.prepareStatement("SELECT * FROM TB_COURSE WHERE ID=" + idCourse + ";");

			ResultSet response = stmt.executeQuery();

			if (response.next()) {
				return makeCourse(response).toString();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

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

	private Course makeCourse(ResultSet response) throws SQLException {

		Course course = new Course();
		course.setId(response.getInt("ID"));
		course.setName(response.getString("NAME"));

		return course;
	}

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
