package controllers;

import dao.StudentDAO;
import entities.Login;
import entities.Student;

public class StudentController {
	
	private StudentDAO studentDao;
	private Student student;
	
	public StudentController(Login login) {
		
		this.studentDao = new StudentDAO();
		
		this.student = studentDao.loginStudent(login);
	}
	

	public String getStudentInformations() {
		return "";
	}

	public void updateStudentInformations() {
	}
	
	public String getCourseEnrolled() {
		return "";
	
	}


}
