package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Student responsible for contains attributes and methods that models a
 * student in the system.
 * 
 *  @author thiagomoura21
 */
public class Student {

	/*
	 * ID unique of a student.
	 */
	private int id;

	/*
	 * Name of a student.
	 */
	private String name;

	/*
	 * Address of a student.
	 */
	private String address;

	/*
	 * Nationality of a student.
	 */
	private String nationality;

	/*
	 * Course ID that the student is. If it is not in one, it is zero.
	 */
	private int idCourse;

	/**
	 * Constructor composed of a student.
	 * 
	 * @param name
	 *            His new name.
	 * @param address
	 *            His new address.
	 * @param nationality
	 *            His new nationality.
	 */
	public Student(String name, String address, String nationality) {
		this.setName(name);
		this.setAddress(address);
		this.setNationality(nationality);
	}

	/**
	 * Constructor of empty student.
	 */
	public Student() {

	}

	// gets and sets;
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

	/**
	 * Overwriting the toString containing proper textual representation of a
	 * student.
	 */
	@Override
	public String toString() {

		String course = "";
		if (getCourse() != 0)
			course = "" + getCourse();
		else
			course = "No course";

		return "ID: " + getId() + System.lineSeparator() + "NAME: " + getName() + System.lineSeparator() + "ADDRESS: "
				+ getAddress() + System.lineSeparator() + "NATIONALITY: " + getNationality() + System.lineSeparator()
				+ "COURSE ID: " + course + System.lineSeparator();
	}

	/**
	 * Method to string map returns a map of a student's attributes, crucial for the
	 * update views.
	 * 
	 * @return Map <String, String> where the key is what the attribute is and the
	 *         value is its value.
	 */
	public Map<String, String> toMapString() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("NAME", getName());
		attributes.put("ADDRESS", getAddress());
		attributes.put("NATIONALITY", getNationality());
		return attributes;
	}
}
