package controllers;

import java.util.List;

import dao.CourseDAO;
import entities.Course;

/**
 * Class responsible for being the system course controller. It makes use of its
 * respective data access object to delegate the necessary actions.
 *
 */
public class CourseController {

	/*
	 * Data access object of the course.
	 */
	private CourseDAO courseDao;

	/**
	 * Constructor responsible for creating a new courseDao.
	 */
	public CourseController() {
		this.courseDao = new CourseDAO();
	}

	/**
	 * Method responsible for returning the textual representation of a course from
	 * its ID, if it does not exist, "No course!" is informed.
	 * 
	 * @param ID
	 *            of the course to be searched.
	 * @return Return a textual representation of the course.
	 */
	public String getCourseInformations(int idCourse) {
		Course result = courseDao.getCourseById(idCourse);
		if (result != null)
			return result.toString();
		else
			return "No course!";
	}

	/**
	 * Method responsible for returning a string containing all the textual
	 * representations of the courses in the system. If there are none, "No courses
	 * registered!" is informed.
	 * 
	 * @return Return a textual representation of the courses.
	 */
	public String getAllCourses() {
		List<Course> courses = courseDao.getAllCourses();
		if (!courses.isEmpty()) {
			String result = "";

			for (Course c : courses) {
				result += c.toString() + System.lineSeparator();
			}
			return result;

		} else
			return "No courses registered!";
	}

	/**
	 * Method responsible for delegating the creation of a new course stating its
	 * name.
	 * 
	 * @param courseName
	 *            Name of the new course.
	 */
	public void insertCourse(String courseName) {
		courseDao.insert(courseName);
	}

	/**
	 * Method responsible for delegating the deletion of a course in the system
	 * informing its id
	 * 
	 * @param idCourse
	 *            Course ID will be deleted.
	 */
	public void deleteCourse(int idCourse) {
		courseDao.deleteCourse(idCourse);
	}

	/**
	 * Method responsible for returning a boolean indicating the existence or not of
	 * a course in the system. Code reuse is done.
	 * 
	 * @param idCourse
	 *            ID of the course.
	 * @return Return a boolean with the result of the search.
	 */
	public boolean existCourse(int idCourse) {
		return !getCourseInformations(idCourse).equals("No course!");
	}
}
