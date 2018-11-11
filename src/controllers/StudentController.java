package controllers;

import java.util.List;
import java.util.Map;

import dao.StudentDAO;
import entities.Student;

/**
 * Class responsible for being the system student controller. It makes use of
 * its respective data access object to delegate the necessary actions.
 *
 * @author thiagomoura21
 */
public class StudentController {

	/*
	 * Data access object of the student.
	 */
	private StudentDAO studentDao;

	/**
	 * Constructor responsible for creating a new studentDao.
	 */
	public StudentController() {
		this.studentDao = new StudentDAO();
	}

	/**
	 * Method responsible for returning a string containing all the textual
	 * representations of the students in the system. If there are none, "Don't have
	 * students registered!" is informed.
	 * 
	 * @return Return a textual representation of the students.
	 */
	public String getAllStudents() {
		List<Student> students = studentDao.getAllStudents();
		if (!students.isEmpty()) {
			String result = "";

			for (Student s : students) {
				result += s.toString() + System.lineSeparator();
			}
			return result;

		} else
			return "Don't have students registered!";
	}

	/**
	 * Method responsible for returning a string containing all the textual
	 * representations of the students who are registered in the course. If there
	 * are none, "Don't have students in this course!" is informed.
	 * 
	 * @return Return a textual representation of the students.
	 */
	public String getStudentsInCourse(int idCourse) {
		List<Student> students = studentDao.getStudentsInCourse(idCourse);
		if (!students.isEmpty()) {
			String result = "";

			for (Student s : students) {
				result += s.toString() + System.lineSeparator();
			}
			return result;

		} else
			return "Don't have students in this course!";
	}

	/**
	 * Method responsible for delegating the creation of a new student stating its
	 * name, address and nationality.
	 * 
	 * @param name
	 *            Name of the new student.
	 * @param address
	 *            Address of the new student.
	 * @param nationality
	 *            Nationality of the new student.
	 */
	public void insertStudent(String name, String address, String nationality) {
		studentDao.insert(new Student(name, address, nationality));

	}

	/**
	 * Method responsible for delegating the deletion of a student in the system
	 * informing its id
	 * 
	 * @param idStudent
	 *            Student ID will be deleted.
	 */
	public void deleteStudent(int idStudent) {
		studentDao.deleteStudent(idStudent);
	}

	/**
	 * Method responsible for returning a student's id from the given name
	 * 
	 * @param name
	 *            Name of the student searched.
	 * @return ID of the student.
	 */
	public int getStudentIdByName(String name) {
		return studentDao.getStudentByName(name).getId();
	}

	/**
	 * Method responsible for returning the textual representation of a student from
	 * its ID.
	 * 
	 * @param ID
	 *            ID of the student to be searched.
	 * @return Return a textual representation of the student.
	 */
	public String getStudentInformationsById(int idStudent) {
		return studentDao.getStudentById(idStudent).toString();
	}

	/**
	 * 
	 * Method responsible for delegating a student update by passing on the
	 * information received.
	 * 
	 * @param id
	 *            ID of the student.
	 * @param name
	 *            Name of the student.
	 * @param address
	 *            Address of the student.
	 * @param nationality
	 *            Nationality of the student.
	 */
	public void updateStudent(int id, String name, String address, String nationality) {
		Student student = new Student(name, address, nationality);
		student.setId(id);
		studentDao.updateStudent(student);
	}

	/**
	 * 
	 * Method responsible for delegating a student's registration in the course.
	 * 
	 * @param idStudent
	 *            ID of the student chosen
	 * @param idCourse
	 *            ID of the course.
	 */
	public void setStudentInCourse(int idStudent, int idCourse) {
		studentDao.setStudentInCourse(idStudent, idCourse);
	}

	/**
	 * 
	 * Method responsible for delegating the deletion of the course indicated in the
	 * students who have this course.
	 * 
	 * @param idCourse
	 *            Course ID deleted.
	 */
	public void deleteCourseInStudents(int idCourse) {
		studentDao.deleteCourseInStudents(idCourse);
	}

	/**
	 * Method responsible for returning a representation textual of the student from
	 * the given name.
	 * 
	 * @param name
	 *            Name of the student searched.
	 * @return String with the student representation.
	 */
	public String getStudentByName(String nameStudent) {

		Student student = studentDao.getStudentByName(nameStudent);
		if (student != null)
			return student.toString();
		else
			return "Don't exist student with this name!";
	}

	/**
	 * 
	 * Method responsible for returning the course id that the student is enrolled
	 * in.
	 * 
	 * @param idStudent
	 *            ID of the chosen student.
	 * @return int of the ID Course.
	 */
	public int getIdCourse(int idStudent) {
		return studentDao.getStudentById(idStudent).getCourse();
	}

	/**
	 * 
	 * Method responsible for returning a boolean representing the existence or not
	 * of a student in the system. Reuse of code made.
	 * 
	 * @param idStudent
	 *            ID of the chosen student.
	 * @return Return a boolean with the result of the search.
	 */
	public boolean existStudent(int idStudent) {
		return studentDao.getStudentById(idStudent) != null;
	}

	/**
	 * Method responsible for returning a map with chosen student values. This
	 * method is used in the update function of the system.
	 * 
	 * @param idStudent
	 *            ID of the chosen student.
	 * @return Return a Map with this values.
	 */
	public Map<String, String> getStudentDataInMap(int idStudent) {
		return studentDao.getStudentById(idStudent).toMapString();
	}
}
