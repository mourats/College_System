package view.student;

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
import view.student.UpdateYourOwnProfile;

public class StudentDashboard extends JFrame {

	private static final long serialVersionUID = -17358249654992114L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StudentDashboard(int x, int y) {
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
		
		JButton btnViewProfile = new JButton("View My Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemCollege system = SystemCollege.getInstanceSystem();
				JOptionPane.showMessageDialog(null, system.getPerfilStudent(), "My Profile", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewProfile.setBounds(70, 86, 297, 25);
		contentPane.add(btnViewProfile);
		
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
		
		JButton btnWhatCourse = new JButton("See What Course I'm in");
		btnWhatCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemCollege system = SystemCollege.getInstanceSystem();
				JOptionPane.showMessageDialog(null, system.getCourseEnrolled(), "My Course", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnWhatCourse.setBounds(70, 162, 297, 25);
		contentPane.add(btnWhatCourse);
	}

}
