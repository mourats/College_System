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

public class ViewLogin extends JFrame {

	private static final long serialVersionUID = -2987285739596576965L;

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private SystemCollege system;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewLogin() {

		system = SystemCollege.getInstanceSystem();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("COLLEGE SYSTEM");
		lblTitle.setBounds(126, 29, 212, 40);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblTitle);

		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(140, 127, 46, 15);
		contentPane.add(lblUser);

		user = new JTextField();
		user.setBounds(182, 127, 114, 19);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 167, 75, 15);
		contentPane.add(lblPassword);

		password = new JPasswordField();
		password.setBounds(182, 165, 114, 19);
		contentPane.add(password);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String userString = user.getText().trim();
				String passwordString = new String(password.getPassword()).trim();

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

				} else {
					JOptionPane.showMessageDialog(null, "Login Incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
					user.setText("");
					password.setText("");
				}
			}
		});
		btnLogin.setBounds(179, 223, 117, 25);
		contentPane.add(btnLogin);
	}
}
