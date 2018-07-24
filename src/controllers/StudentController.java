package controllers;

import java.util.List;
import java.util.Map;

import dao.StudentDAO;
import entities.Student;

public class StudentController {

	private StudentDAO studentDao;

	public StudentController() {
		this.studentDao = new StudentDAO();

	}

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

	public void insertStudent(String name, String address, String nationality) {
		studentDao.insert(new Student(name, address, nationality));

	}

	public void deleteStudent(int idStudent) {
		studentDao.deleteStudent(idStudent);
	}
	
	public int getStudentIdByName(String name) {
		return studentDao.getStudentByName(name).getId();
	}

	public String getStudentInformationsById(int idStudent) {
		return studentDao.getStudentById(idStudent).toString();
	}

	public void updateStudent(int id, String name, String address, String nationality) {
		Student student = new Student(name, address, nationality);
		student.setId(id);
		studentDao.updateStudent(student);
	}

	public void setStudentInCourse(int idStudent, int idCourse) {
		studentDao.setStudentInCourse(idStudent, idCourse);
	}

	public void deleteCourseInStudents(int idCourse) {
		studentDao.deleteCourseInStudents(idCourse);
	}

	public String getStudentByName(String nameStudent) {

		Student student = studentDao.getStudentByName(nameStudent);
		if (student != null)
			return student.toString();
		else
			return "Don't exist student with this name!";
	}

	public int getIdCourse(int idStudent) {
		return studentDao.getStudentById(idStudent).getCourse();
	}

	public boolean existStudent(int idStudent) {
		return studentDao.existStudent(idStudent);
	}

	public Map<String, String> getStudentDataInMap(int idStudent) {
		return studentDao.getStudentById(idStudent).toMapString();
	}
	
}
