package system;

import controllers.CourseController;
import controllers.LoginController;
import controllers.StudentController;

public class System {

	private static System instance;

	private CourseController courseController;
	private LoginController loginController;
	private StudentController studentController;

	public System(String name, String password) {

	}

	public static System getInstance() {
		return instance;
	}
}
