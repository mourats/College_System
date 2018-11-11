package view.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import system.SystemCollege;
import view.main.ViewLogin;
import view.student.UpdateYourOwnProfile;

/**
 * Student Dashboard containing all the functions defined for a student. These
 * functions are activated from the button menu. instantiating and redirecting
 * the necessary jframe when necessary.
 *
 * @author thiagomoura21
 */
public class StudentDashboard extends JFrame {

	private static final long serialVersionUID = -17358249654992114L;

	private JPanel contentPane;
	private SystemCollege system;

	public StudentDashboard(int x, int y) {

		// Acquiring the unique instance of the system
		system = SystemCollege.getInstanceSystem();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Student");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(172, 12, 107, 41);
		contentPane.add(lblTitle);

		//JButton for function of see the profile.
		JButton btnViewProfile = new JButton("View My Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, system.getPerfilStudent(), "My Profile",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewProfile.setBounds(70, 86, 297, 25);
		contentPane.add(btnViewProfile);

		//JButton for function of change your own profile.
		JButton btnChangeProfile = new JButton("Change My Profile Data");
		btnChangeProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				UpdateYourOwnProfile updateProfile = new UpdateYourOwnProfile(x, y);
				updateProfile.setVisible(true);
			}
		});
		btnChangeProfile.setBounds(70, 123, 297, 25);
		contentPane.add(btnChangeProfile);

		//JButton for function of see what course i am assing.
		JButton btnWhatCourse = new JButton("See What Course I'm in");
		btnWhatCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, system.getCourseEnrolled(), "My Course",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnWhatCourse.setBounds(70, 162, 297, 25);
		contentPane.add(btnWhatCourse);

		// JButton for function of logout.
		// This button clear the actual instance of the system and create a Jframe
		// initial of login.
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				system.clearInstanceSystem();
				ViewLogin loginAgain = new ViewLogin(getX(), getY());
				dispose();
				loginAgain.setVisible(true);
			}
		});
		btnLogout.setBounds(162, 221, 117, 25);
		btnLogout.setBackground(new Color(240, 128, 128));
		contentPane.add(btnLogout);
	}

}
