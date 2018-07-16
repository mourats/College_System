package entities;

public class Login {
	
	private String login_name;
	private String password;
	
	public Login(String name, String password) {
		this.login_name = name;
		this.password = password;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
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
}
