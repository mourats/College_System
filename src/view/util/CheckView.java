package view.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckView extends JFrame {

	private static final long serialVersionUID = 2963640596907742784L;

	public static boolean verifyUsername(String userString) {
		if (userString.equals("")) {
			JOptionPane.showMessageDialog(null, "Username Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}

	public static boolean verifyPassword(String password) {
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Password Empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else
			return true;
	}
}
