package system;

import java.util.Map;

import controllers.CourseController;
import controllers.LoginController;
import controllers.StudentController;

/**
 * Class responsible for being the main controller of the system, as well as the
 * facade used by the graphical interface. Containing the three system
 * controllers, it delegates actions to them by covering what is defined in the
 * methods. It uses the singleton pattern. because of this there is only one
 * instance of the SystemCollege throughout the system execution.
 *
 */
public class SystemCollege {

	/*
	 * Single instance of the SystemCollege.
	 */
	private static SystemCollege instance;

	/*
	 * Course controller. functions with the course context are executed through it.
	 */
	private CourseController courseController;

	/*
	 * Login controller. functions with the login context are executed through it.
	 */
	private LoginController loginController;

	/*
	 * Student controller. functions with the student context are executed through
	 * it.
	 */
	private StudentController studentController;

	/**
	 * Private constructor of SystemCollege, executed in the first instantiation.
	 */
	private SystemCollege() {
		this.loginController = new LoginController();
		this.loginController.initialLoginForAdmin();
	}

	/**
	 * Static method responsible for returning the unique instance of system
	 * college. When it has not been instantiated, it is responsible for
	 * accomplishing this instantiation;
	 * 
	 * @return Object of SystemCollege.
	 */
	public static SystemCollege getInstanceSystem() {
		if (instance == null)
			instance = new SystemCollege();

		return instance;
	}

	/**
	 * Method responsible for clearing the existing SystemCollege instance. used
	 * when a logout occurs.
	 */
	public void clearInstanceSystem() {
		SystemCollege.instance = null;
	}

	/*
	 * Private method responsible for initializing the other controllers. this
	 * happens when there is a successful login.
	 */
	private void logonSuccessful() {
		this.studentController = new StudentController();
		this.courseController = new CourseController();
	}

	// Admin functions

	/**
	 * Method responsible for delegating the verification of existence of the login
	 * of an admin entered, returning the boolean value of the result. when it is
	 * true, logonSuccessful() is called.
	 * 
	 * @param userName
	 *            User Name informed.
	 * @param password
	 *            Password informed.
	 * 
	 * @return Returns a boolean with the result of the check.
	 */
	public boolean loginAdmin(String userName, String password) {

		boolean loginResult = loginController.loginAdmin(userName, password);
		if (loginResult) {
			logonSuccessful();
			return true;
		} else
			return false;
	}

	/**
	 * Method responsible for delegating the search for all courses enrolled in the
	 * system through the course controller.
	 * 
	 * @return Return a result of the search.
	 */
	public String getAllCourses() {
		return courseController.getAllCourses();
	}

	/**
	 * Method responsible for delegating the search for all student enrolled in the
	 * system through the student controller.
	 * 
	 * @return Return a result of the search.
	 */
	public String getAllStudents() {
		return studentController.getAllStudents();
	}

	/**
	 * Method responsible for delegating the search for all student enrolled in a
	 * course informed. The system through the student controller.
	 * 
	 * @param idCourse
	 *            Course ID informed.
	 * @return Return a result of the search.
	 */
	public String getStudentsInCourse(int idCourse) {
		return studentController.getStudentsInCourse(idCourse);
	}

	/**
	 * Method responsible for delegating the registration of a student to a course.
	 * This is done through the student controller, searching and assigning the
	 * course id in the specified field.
	 * 
	 * @param idStudent
	 *            Id of the student who was chosen to be enrolled in the course.
	 * 
	 * @param idCourse
	 *            ID of the course chosen.
	 */
	public void setStudentInCourse(int idStudent, int idCourse) {
		studentController.setStudentInCourse(idStudent, idCourse);
	}

	/**
	 * Method responsible for delegating the creation of a new course for the course
	 * controller.
	 * 
	 * @param courseName
	 *            Name of the new course.
	 */
	public void addNewCourse(String courseName) {
		courseController.insertCourse(courseName);
	}

	/**
	 * Method responsible for delegating the creation of a new student for the
	 * student controller. After doing this the student ID is retrieved and the one
	 * new login is generated for it. The textual representation of this new login
	 * is returned.
	 * 
	 * @param name
	 *            Name of the new student.
	 * @param address
	 *            Address of the new student.
	 * @param nationality
	 *            Nationality of the new student.
	 * @return Return the representation of the login of this new student.
	 */
	public String addNewStudent(String name, String address, String nationality) {

		studentController.insertStudent(name, address, nationality);
		int idStudent = studentController.getStudentIdByName(name);
		String loginResult = loginController.generateLogin(idStudent);
		return loginResult;
	}

	/**
	 * Method responsible for delegating the deletion of a student through his or
	 * her ID. This is delegated to the student controller, since the deletion of
	 * your login is delegated to the login controller.
	 * 
	 * @param idStudent
	 *            Student ID will be deleted.
	 */
	public void deleteStudentById(int idStudent) {
		loginController.deleteLogin(idStudent);
		studentController.deleteStudent(idStudent);
	}

	/**
	 * Method responsible for delegating the deletion of a course through his ID.
	 * This is delegated to the course controller, since the deletion of the ID
	 * course in the students is delegated to the student controller.
	 * 
	 * @param idCourse
	 *            Coruse ID will be deleted.
	 */
	public void deleteCourse(int idCourse) {
		studentController.deleteCourseInStudents(idCourse);
		courseController.deleteCourse(idCourse);
	}

	/**
	 * Method responsible for delegating the update of a student passing all
	 * necessary information to the student controller.
	 * 
	 * @param id
	 *            ID of the student.
	 * @param name
	 *            His new name.
	 * @param address
	 *            His new address.
	 * @param nationality
	 *            His new nationality.
	 */
	public void updateStudent(int id, String name, String address, String nationality) {
		studentController.updateStudent(id, name, address, nationality);
	}

	/**
	 * Method responsible for delegating the search for the textual representation
	 * of a student through his / her id. By studentController.
	 * 
	 * @param idStudent
	 *            ID of the student.
	 * @return Representation textual of the student.
	 */
	public String getPerfilStudentById(int idStudent) {
		return studentController.getStudentInformationsById(idStudent);
	}

	/**
	 * Method responsible for delegating the search for the textual representation
	 * of a student through his / her name. By studentController.
	 * 
	 * @param nameStudent
	 *            Name of the student.
	 * @return Representation textual of the student.
	 */
	public String getStudentByName(String nameStudent) {
		return studentController.getStudentByName(nameStudent);
	}

	/**
	 * Method responsible for delegating the existence verification of a course to
	 * the course controller.
	 * 
	 * @param idCourse
	 *            ID of the course.
	 * @return Boolean result of the search.
	 */
	public boolean existCourse(int idCourse) {
		return courseController.existCourse(idCourse);
	}

	/**
	 * Method responsible for delegating the existence verification of a student to
	 * the student controller.
	 * 
	 * @param idStudent
	 *            ID of the student.
	 * @return Boolean result of the search.
	 */
	public boolean existStudent(int idStudent) {
		return studentController.existStudent(idStudent);
	}

	/**
	 * Method responsible for delegating the search for the map of the attributes of
	 * a student through his / her ID. By studentController.
	 * 
	 * @param idStudent
	 *            ID of the student.
	 * @return Map <String, String> with attribute keys and values ​​with their
	 *         values.
	 */
	public Map<String, String> getStudentDataInMap(int idStudent) {
		return studentController.getStudentDataInMap(idStudent);
	}

	// Student functions

	/**
	 * Method responsible for delegating the verification of existence of the login
	 * of a student entered, returning the boolean value of the result. when it is
	 * true, logonSuccessful() is called.
	 * 
	 * @param userName
	 *            User Name informed.
	 * @param password
	 *            Password informed.
	 * 
	 * @return Returns a boolean with the result of the check.
	 */
	public boolean loginStudent(String name, String password) {
		boolean loginResult = loginController.loginStudent(name, password);
		if (loginResult) {
			logonSuccessful();
			return true;
		} else
			return false;
	}

	/**
	 * Method responsible for delegating the search for the textual representation
	 * of a student currently logged into the system. First your id is returned by
	 * the login controller, after studentController is used.
	 * 
	 * @return Representation textual of the student.
	 */
	public String getPerfilStudent() {
		int idStudent = loginController.getStudentId();
		return studentController.getStudentInformationsById(idStudent) + getLoginStudent();
	}

	/**
	 * Method responsible for returning the textual representation of the student
	 * currently logged into the system. All the controllers are used.
	 * 
	 * @return Representation textual of the course.
	 */
	public String getCourseEnrolled() {
		int idStudent = loginController.getStudentId();
		int idCourse = studentController.getIdCourse(idStudent);
		return courseController.getCourseInformations(idCourse);
	}

	/**
	 * Private method responsible for returning the textual representation of the
	 * student's login currently logged into the system.
	 * 
	 * @return Representation textual of the login.
	 */
	private String getLoginStudent() {
		return loginController.getLoginStudent();
	}

	/**
	 * Method responsible for delegating the update of a student currently logged
	 * into the system passing all necessary information to the student controller
	 * and login controller.
	 * 
	 * @param name
	 *            His new name.
	 * @param address
	 *            His new address.
	 * @param nationality
	 *            His new nationality.
	 * @param userName
	 *            His new userName.
	 * @param password
	 *            His new password.
	 */
	public void updateStudentOwnProfile(String name, String address, String nationality, String userName,
			String password) {
		int idStudent = loginController.getStudentId();
		studentController.updateStudent(idStudent, name, address, nationality);
		loginController.updateOwnLogin(userName, password);
	}

	/**
	 * Method responsible for delegating the search for the map of the attributes of
	 * a login currently logged into the system. By loginController.
	 * 
	 * @return Map <String, String> with attribute keys and values ​​with their
	 *         values.
	 */
	public Map<String, String> getLoginOwnDataInMap() {
		return loginController.getLoginDataInMap();
	}

	/**
	 * Method responsible for delegating the search for the map of the attributes of
	 * a student currently logged into the system. By studentController.
	 * 
	 * @return Map <String, String> with attribute keys and values ​​with their
	 *         values.
	 */
	public Map<String, String> getStudentOwnDataInMap() {
		int idStudent = loginController.getStudentId();
		return getStudentDataInMap(idStudent);
	}
}
