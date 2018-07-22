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

	public String generateLogin(int idStudent) {
		Login login = new Login("student" + idStudent, "12345");
		login.setIdStudent(idStudent);
		loginDao.insertLogin(login);
		return login.toString();
	}

	public void deleteLogin(int idStudent) {
		loginDao.deleteLogin(idStudent);
	}
}
