package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Login responsible for contains attributes and methods that models a
 * login in the system.
 * 
 *  @author thiagomoura21
 */
public class Login {

	/*
	 * User Name of a login. 
	 */
	private String loginName;
	
	/*
	 * Password of a login.
	 */
	private String password;
	
	/*
	 * Student ID owns this login.
	 */
	private int idStudent;

	/**
	 * Constructor composed of a course.
	 * 
	 * @param loginName His new login name.
	 * @param password His new password.
	 */
	public Login(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
	}

	//gets and sets
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String login_name) {
		this.loginName = login_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	/**
	 * Overwriting the toString containing proper textual representation of a
	 * login.
	 */
	@Override
	public String toString() {
		return "LOGIN NAME: " + getLoginName() + System.lineSeparator() + "PASSWORD: " + getPassword();
	}

	/**
	 * Method to string map returns a map of a login's attributes, crucial for the
	 * update view of a StudentDashboard.
	 * 
	 * @return Map <String, String> where the key is what the attribute is and the
	 *         value is its value.
	 */
	public Map<String, String> toMapString() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("LOGIN NAME", getLoginName());
		attributes.put("PASSWORD", getPassword());
		return attributes;
	}
}
