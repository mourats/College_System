package controllers;

import java.util.List;

import dao.CourseDAO;
import dao.StudentDAO;
import entities.Admin;
import entities.Course;
import entities.Login;
import entities.Student;

public class AdminDashboard {

	private StudentDAO studentDao;
	private CourseDAO courseDao;
	private Admin admin;

	public AdminDashboard(Login login) {
		this.admin = new Admin(login);
		this.studentDao = new StudentDAO();
	}

	public List<String> getAllCourses() {
		return courseDao.getAllCourses();
	}

	public List<String> getAllStudents() {
		return studentDao.getAllStudents();
	}

	public List<String> getStudentsInCourse(int idCourse) {
		return studentDao.getStudentsInCourse(idCourse);
	}

	public void setStudentInCourse(int idStudent, int idCourse) {
		studentDao.setStudentInCourse(idStudent, idCourse);
	}

	public int addNewCourse(String name) {
		Course course = new Course(name);
		int id = courseDao.insert(course);
		course.setId(id);
		return id;
	}

	public int addNewStudent(String name, String address, String nationality) {
		Student student = new Student(name, address, nationality, Login.generateLOGIN(name));
		int id = studentDao.insert(student);
		student.setId(id);
		return id;
	}

	public void deleteStudentById(int id) {
		studentDao.deleteStudent(id);
	}

	public void updateStudent(String name, String address, String nationality, String login_name, String password) {
		Student student = new Student(name, address, nationality, new Login(login_name, password));
		studentDao.updateStudent(student);
	}
	
	public String getPerfil() {
		return admin.toString();
	}

}
