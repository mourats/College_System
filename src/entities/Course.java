package entities;

/**
 * Class Course responsible for contains attributes and methods that models a
 * course in the system.
 */
public class Course {
	
	/*
	 * ID unique of a course.
	 */
	private int id;
	
	/*
	 * Name of a course;
	 */
	private String name;
	
	/**
	 * Constructor composed of a course.
	 * @param course His new name.  
	 */
	public Course(String name) {
		this.name = name;
	}
	
	/*
	 * Constructor empty of a course.
	 */
	public Course() {
	}

	// gets and sets
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
	
	/**
	 * Overwriting the toString containing proper textual representation of a
	 * course.
	 */
	@Override
	public String toString() {
		return "ID: " + getId() + System.lineSeparator() + "NAME: " + getName() + System.lineSeparator();
	}
}
