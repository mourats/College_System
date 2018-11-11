package view.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import system.SystemCollege;

/**
 * Class responsible for containing static methods that check the input data,
 * returning a boolean value with the result of the arrival. A dialog box opens
 * if not, informing which error occurred.
 *
 * @author thiagomoura21
 */
public class CheckView extends JFrame {

	private static final long serialVersionUID = 2963640596907742784L;

	public static boolean verifyUsername(String userString) {
		if (userString.equals("")) {
			JOptionPane.showMessageDialog(null, "Username is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyPassword(String password) {
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Password is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyName(String nameString) {
		if (nameString.equals("")) {
			JOptionPane.showMessageDialog(null, "Name is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyAddress(String addressString) {
		if (addressString.equals("")) {
			JOptionPane.showMessageDialog(null, "Address is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyNationality(String nationalityString) {
		if (nationalityString.equals("")) {
			JOptionPane.showMessageDialog(null, "Nationality is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyIdCourseEmpty(String idCourseString) {
		if (idCourseString.equals("")) {
			JOptionPane.showMessageDialog(null, "ID Course is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyIdStudentEmpty(String idStudentString) {
		if (idStudentString.equals("")) {
			JOptionPane.showMessageDialog(null, "ID Student is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyIdCourseIsNumber(String idCourseString) {
		try {
			Integer.parseInt(idCourseString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID Course is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean verifyIdStudentIsNumber(String idStudentString) {
		try {
			Integer.parseInt(idStudentString);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID Student is not a number!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean verifyIdCourseExist(String idCourseString) {
		SystemCollege system = SystemCollege.getInstanceSystem();
		if (system.existCourse(Integer.parseInt(idCourseString)))
			return true;
		else {
			JOptionPane.showMessageDialog(null, "Course does not exist in system!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public static boolean verifyIdStudentExist(String idStudentString) {
		SystemCollege system = SystemCollege.getInstanceSystem();
		if (system.existStudent(Integer.parseInt(idStudentString)))
			return true;
		else {
			JOptionPane.showMessageDialog(null, "Student does not exist in system!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
