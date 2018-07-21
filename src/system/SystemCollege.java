package system;

import java.util.List;

import controllers.CourseController;
import controllers.LoginController;
import controllers.StudentController;

public class SystemCollege {

	private static SystemCollege instance;

	private CourseController courseController;
	private LoginController loginController;
	private StudentController studentController;

	private SystemCollege() {
		this.loginController = new LoginController();
	}

	public boolean loginAdmin(String name, String password) {
		boolean loginResult = loginController.loginAdmin(name, password);
		if (loginResult) {
			logonSuccessful();
			return true;
		} else
			return false;
	}

	public boolean loginStudent(String name, String password) {
		return false;

	}

	private void logonSuccessful() {
		this.studentController = new StudentController();
		this.courseController = new CourseController();
		System.out.println("Oi deu certo");
	}

	public static SystemCollege getInstanceSystem() {
		if (instance == null)
			instance = new SystemCollege();

		return instance;
	}

	// Admin functions

	public List<String> getAllCourses() {
		return courseController.getAllCourses();
	}

	public List<String> getAllStudents() {
		return studentController.getAllStudents();
	}

	public List<String> getStudentsInCourse(int idCourse) {

		return studentController.getStudentsInCourse(idCourse);
	}

	public void setStudentInCourse(int idStudent, int idCourse) {

		studentController.setStudentInCourse(idStudent, idCourse);
	}

	public int addNewCourse(String courseName) {

		int idCourse = courseController.insertCourse(courseName);
		return idCourse;
	}

	public int addNewStudent(String name, String address, String nationality) {

		int idStudent = studentController.insertStudent(name, address, nationality);
		return idStudent;
	}

	public void deleteStudentById(int idStudent) {
		studentController.deleteStudent(idStudent);
	}

	public void updateStudent(int id, String name, String address, String nationality, String loginName,
			String password) {
		studentController.updateStudent(id, name, address, nationality, loginName, password);
	}

	// Student functions

	public String getCourseEnrolled(int idStudent) {

		int idCourse = studentController.getIdCourse(idStudent);
		return courseController.getCourseInformations(idCourse);
	}

	public String getPerfilStudent() {
		int idStudent = loginController.getStudentId();
		return studentController.getStudentInformationsById(idStudent);
	}
}
