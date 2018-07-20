package system;

import java.util.List;

import controllers.CourseController;
import controllers.LoginController;
import controllers.StudentController;

public class System {

	private static System instance;

	private CourseController courseController;
	private LoginController loginController;
	private StudentController studentController;

	public System() {
		this.loginController = new LoginController();
	}

	public String logon(String name, String password) {

		String loginResult = loginController.logon(name, password);

		if (loginResult != null)
			logonSuccessful();

		return loginResult;
	}

	private void logonSuccessful() {
		this.studentController = new StudentController();
		this.courseController = new CourseController();
	}

	public static System getInstanceSystem() {
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

	public void updateStudent(int id, String name, String address, String nationality, String loginName, String password) {
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
