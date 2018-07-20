package controllers;

import dao.LoginDAO;
import entities.Login;

public class LoginController {

	private Login loginSession;
	private LoginDAO loginDao;

	public LoginController() {

	}

	public String logon(String name, String password) {

		Login login = new Login(name, password);
		String resultSearch = loginDao.login(login);
		
		if(resultSearch != null)
			this.loginSession = login;
		
		return resultSearch;
	}
	
	public int getStudentId(){
		return this.loginSession.getIdStudent();
	}
}
