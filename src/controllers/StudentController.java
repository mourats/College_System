package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDAO;
import entities.Student;

public class StudentController {
	
	private StudentDAO studentDao;
	
	public StudentController() {
		this.studentDao = new StudentDAO();
		
	}
	
	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getStudentsInCourse(int idCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStudentInCourse(int idStudent, int idCourse) {
		// TODO Auto-generated method stub
		
	}

	public void deleteStudent(int idStudent) {
		// TODO Auto-generated method stub
		
	}

	public void updateStudent(int id, String name, String address, String nationality, String loginName,
			String password) {
		// TODO Auto-generated method stub
		
	}

	public String getStudentInformationsById(int idStudent) {
		Student student;
		try {
			student = studentDao.getStudentById(idStudent);
			return student.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getStudentInformationsByName(String nameStudent) {
		int id;
		try {
			id = studentDao.getStudentIdByName(nameStudent);
			return studentDao.getStudentById(id).toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public int insertStudent(String name, String address, String nationality) {
		try {
			return studentDao.insert(new Student(name, address, nationality));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int getIdCourse(int idStudent) {
		try {
			return studentDao.getStudentById(idStudent).getCourse();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idStudent;
	}


	
}
