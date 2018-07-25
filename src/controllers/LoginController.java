package controllers;

import java.util.Map;

import dao.LoginDAO;
import entities.Login;

/**
 * Class responsible for being the system login controller. It makes use of its
 * respective data access object to delegate the necessary actions, as well as
 * saves the login that is currently logged into the system.
 *
 */
public class LoginController {

	/*
	 * Login currently logged into the system.
	 */
	private Login loginSession;

	/*
	 * Data access object of the login.
	 */
	private LoginDAO loginDao;

	/**
	 * Constructor responsible for creating a new loginDao.
	 */
	public LoginController() {
		this.loginDao = new LoginDAO();
	}

	/**
	 * Method responsible for returning the id of the student logged into the
	 * system.
	 * 
	 * @return Return a int with the student ID.
	 */
	public int getStudentId() {
		return this.loginSession.getIdStudent();
	}

	/**
	 * Method responsible for delegating verification of existence of the login
	 * admin entered returning the boolean result
	 * 
	 * @param name
	 *            Login name informed.
	 * @param password
	 *            Password name informed.
	 * @return Return a boolean with the result.
	 */
	public boolean loginAdmin(String name, String password) {
		Login login = new Login(name, password);
		boolean loginResult = loginDao.loginAdmin(login);
		if (loginResult) {
			this.loginSession = login;
			return true;
		} else
			return false;
	}

	/**
	 * Method responsible for delegating verification of existence of the login
	 * student entered returning the boolean result
	 * 
	 * @param name
	 *            Login name informed.
	 * @param password
	 *            Password name informed.
	 * @return Return a boolean with the result.
	 */
	public boolean loginStudent(String name, String password) {
		Login login = new Login(name, password);
		boolean loginResult = loginDao.loginStudent(login);
		if (loginResult) {
			this.loginSession = login;
			return true;
		} else
			return false;
	}

	/**
	 * Method responsible for generating a new student login. This happens when a
	 * new student is entered into the system
	 * 
	 * @param idStudent
	 *            Student ID owns the login.
	 * @return Return the representation textual of the generated login.
	 */
	public String generateLogin(int idStudent) {
		Login login = new Login("student" + idStudent, "12345");
		login.setIdStudent(idStudent);
		loginDao.insertLogin(login);
		return login.toString();
	}

	/**
	 * Method responsible for delegating the deletion of a login. this happens when
	 * a student is deleted from the system.
	 * 
	 * @param idStudent
	 *            ID of student login and deleted system
	 */
	public void deleteLogin(int idStudent) {
		loginDao.deleteLogin(idStudent);
	}

	/**
	 * Method responsible for returning the textual representation of the currently
	 * logged in login.
	 * 
	 * @return Return a string of the representation.
	 */
	public String getLoginStudent() {
		return loginSession.toString();
	}

	/**
	 * Method responsible for updating the currently logged in login, with the data
	 * informed.
	 * 
	 * @param userName
	 *            User name informed.
	 * @param password
	 *            Password informed.
	 */
	public void updateOwnLogin(String userName, String password) {
		loginSession.setLoginName(userName);
		loginSession.setPassword(password);

		loginDao.updateLoginData(loginSession);
	}

	/**
	 * Method responsible for delegating the creation, if necessary, of the initial
	 * admin login
	 */
	public void initialLoginForAdmin() {
		loginDao.initialLoginForAdmin();
	}

	/**
	 * Method responsible for returning a map with login values ​​currently logged
	 * in. This method is used in the update function of a system login.
	 * 
	 * @return Return a Map with this values.
	 */
	public Map<String, String> getLoginDataInMap() {
		return loginSession.toMapString();
	}
}
