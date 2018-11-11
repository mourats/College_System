package view.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import system.SystemCollege;
import view.admin.AdminDashboard;
import view.student.StudentDashboard;
import view.util.CheckView;

/**
 * Class system main! It contains the login view on the system, instantiating
 * and making the appropriate Dashboard visible.
 *
 * @author thiagomoura21
 */
public class ViewLogin extends JFrame {

	private static final long serialVersionUID = -2987285739596576965L;

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private SystemCollege system;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin(100, 100);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewLogin(int x, int y) {

		// Acquiring the unique instance of the system
		system = SystemCollege.getInstanceSystem();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("COLLEGE SYSTEM");
		lblTitle.setBounds(126, 29, 212, 40);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblTitle);

		JLabel lblUser = new JLabel("UserName:");
		lblUser.setBounds(102, 129, 86, 15);
		contentPane.add(lblUser);
		// TextField of the user name.
		user = new JTextField();
		user.setBounds(182, 127, 114, 19);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 167, 75, 15);
		contentPane.add(lblPassword);
		// Password Field of the password.
		password = new JPasswordField();
		password.setBounds(182, 165, 114, 19);
		contentPane.add(password);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String userString = user.getText().trim();
				String passwordString = new String(password.getPassword()).trim();

				// Boolean variable that defines whether past data is sufficient to proceed with
				// the necessary actions.
				boolean canIGo = checkOfInput(userString, passwordString);
				if (canIGo) {
					int x = getX();
					int y = getY();

					if (system.loginAdmin(userString, passwordString)) {

						AdminDashboard adminView = new AdminDashboard(x, y);
						dispose();
						adminView.setVisible(true);

					} else if (system.loginStudent(userString, passwordString)) {

						StudentDashboard studentView = new StudentDashboard(x, y);
						dispose();
						studentView.setVisible(true);

					} else { // The entered login does not exist in the database.
						JOptionPane.showMessageDialog(null, "Login Incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
						user.setText("");
						password.setText("");
					}
				}
			}
		});
		btnLogin.setBounds(179, 223, 117, 25);
		contentPane.add(btnLogin);
	}

	/**
	 * Private method that delegates the verification of input data and retries a
	 * boolean defining whether it is possible to proceed
	 * 
	 * @param userString
	 *            String of the userName.
	 * @param passwordString
	 *            String of the password.
	 * @return Boolean with the result of the checks.
	 */
	private boolean checkOfInput(String userString, String passwordString) {

		if (!CheckView.verifyUsername(userString)) {
			user.setText("");
			password.setText("");
			return false;
		} else if (!CheckView.verifyPassword(passwordString)) {
			user.setText("");
			password.setText("");
			return false;
		} else
			return true;
	}
}
