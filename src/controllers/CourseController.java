package controllers;

import java.util.List;

import dao.CourseDAO;

public class CourseController {
	
	private CourseDAO courseDao;
	
	public CourseController() {
	}

	public String getCourseInformations(int idCourse) {
		return courseDao.getCourseById(idCourse);
	}

	public List<String> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertCourse(String courseName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
