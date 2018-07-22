package entities;

public class Student {

	private int id;
	private String name;
	private String address;
	private String nationality;
	private int idCourse;

	public Student(String name, String address, String nationality) {
		this.setName(name);
		this.setAddress(address);
		this.setNationality(nationality);
	}

	public Student() {

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public int getCourse() {
		return this.idCourse;
	}

	@Override
	public String toString() {

		String course = "";
		if (getCourse() != 0)
			course = "" + getCourse();
		else
			course = "No course";

		return "ID: " + getId() + System.lineSeparator() + "NAME: " + getName() + System.lineSeparator() + "ADDRESS: "
				+ getAddress() + System.lineSeparator() + "NATIONALITY: " + getNationality() + System.lineSeparator()
				+ "COURSE: " + course + System.lineSeparator();
	}
}
