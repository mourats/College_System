package entities;

public class Course {
	
	private int id;
	private String name;
	
	public Course(String name) {
		this.name = name;
	}
	
	public Course() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ID: " + getId() + System.lineSeparator() + "NAME: " + getName() + System.lineSeparator();
	}
}
