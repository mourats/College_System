package controllers;

import dao.LoginDAO;
import entities.Login;

public class LoginController {

	private Login loginSession;
	private LoginDAO loginDao;

	public LoginController() {
		this.loginDao = new LoginDAO();
	}

	public int getStudentId() {
		return this.loginSession.getIdStudent();
	}

	public boolean loginAdmin(String name, String password) {
		Login login = new Login(name, password);
		boolean loginResult = loginDao.loginAdmin(login);
		if (loginResult) {
			loginSession = login;
			return true;
		} else
			return false;
	}
}
