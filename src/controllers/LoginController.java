package controllers;

import dao.LoginDAO;
import entities.Login;

public class LoginController {
	
	public AdminDashboard loginAdmin(String name_login, String password) {
		
		Login login = new Login(name_login, password);
		LoginDAO loginDao = new LoginDAO();
		boolean existLogin = loginDao.loginAdmin(login);
		
		if(existLogin)
			return new AdminDashboard(login);
		else
			throw new RuntimeException();
	}
	
	public StudentDashboard loginStudent(String name_login, String password) {
		
		Login login = new Login(name_login, password);
		LoginDAO loginDao = new LoginDAO();
		boolean existLogin = loginDao.loginStudent(login);
		
		if(existLogin)
			return new StudentDashboard(login);
		else
			throw new RuntimeException();
	}

}
