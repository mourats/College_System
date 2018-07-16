package entities;

public class Student {

	private int id;
	private String name;
	private String address;
	private String nationality;
	private Login login;

	public void setLogin(Login login) {
		this.login = login;
	}
	public Student(int id, String name, String address, String nationality) {
		
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setNationality(nationality);
		//generate login
		//this.login = login;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Login getLogin() {
		return login;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
