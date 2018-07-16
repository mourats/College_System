package controllers;

import dao.AdminDAO;
import entities.Admin;
import entities.Login;

public class AdminDashboard {
	
	private AdminDAO adminDao;
	private Admin admin;
	
	public AdminDashboard(Login login) {
		this.admin = new Admin(login);
		this.adminDao = new AdminDAO();
	}

	public String getAllCourses() {
		return "";
	};
	
	public String getAllStudents() {
		return "";
	};
	
	public String getStudentsInCourse(int idCourse) {
		return "";
	}
	
	public void setStudentInCourse(int idStudent, int idCourse) {}

	
	public int addNewCourse(String name) {
		return 0; //id
	}
	
	public int addNewStudent(String name, String address, String nationality) {
		//generate Login for student
		return 0; //id
	}
	
	public void deleteStudentById(int id) {
		
	}
	
	public void updateStudent() {
		
	}

}
