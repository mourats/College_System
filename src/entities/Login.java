package entities;

public class Login {
	
	private String loginName;
	private String password;
	private int idStudent;
	
	public Login(String name, String password) {
		this.loginName = name;
		this.password = password;
	}
	
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

	public static Login generateLOGIN(String name) {
		return new Login(name, name);
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	@Override
	public String toString() {
		return "LOGIN NAME: " + getLoginName() + System.lineSeparator() + "PASSWORD: " + getPassword();
	}
}
