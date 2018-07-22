package view.admin;

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
import view.admin.courses.AddNewCourseView;
import view.admin.courses.AssignStudentCourse;
import view.admin.courses.ChoiceACourse;
import view.admin.courses.ChoiceACourseToDelete;
import view.admin.students.AddNewStudentView;
import view.admin.students.ChoiceAStudentToDelete;
import view.admin.students.ChoiceAStudentToUpdate;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 6244993357481124230L;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @param system
	 */
	public AdminDashboard(int x, int y) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Administrator");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(141, 12, 171, 41);
		contentPane.add(lblTitle);

		JButton btnAllCourses = new JButton("View All Courses");
		btnAllCourses.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				SystemCollege system = SystemCollege.getInstanceSystem();
				JOptionPane.showMessageDialog(null, system.getAllCourses(), "Courses", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAllCourses.setBounds(28, 102, 189, 25);
		contentPane.add(btnAllCourses);

		JButton btnNewCourse = new JButton("Add a New Course");
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				AddNewCourseView addCourseView = new AddNewCourseView(x, y);
				addCourseView.setVisible(true);
			}
		});
		btnNewCourse.setBounds(247, 65, 174, 25);
		contentPane.add(btnNewCourse);

		JButton btnAllStudents = new JButton("View All Students");
		btnAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemCollege system = SystemCollege.getInstanceSystem();
				JOptionPane.showMessageDialog(null, system.getAllStudents(), "Students",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAllStudents.setBounds(67, 213, 324, 25);
		contentPane.add(btnAllStudents);

		JButton btnViewAllStudentsCourse = new JButton("View all the Students in a Course");
		btnViewAllStudentsCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceACourse choiceCourseView = new ChoiceACourse(x, y);
				choiceCourseView.setVisible(true);
			}
		});
		btnViewAllStudentsCourse.setBounds(67, 250, 324, 28);
		contentPane.add(btnViewAllStudentsCourse);

		JButton btnNewButton = new JButton("Delete a Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceAStudentToDelete choiceStudentView = new ChoiceAStudentToDelete(x, y);
				choiceStudentView.setVisible(true);
			}
		});
		btnNewButton.setBounds(67, 290, 324, 25);
		contentPane.add(btnNewButton);

		JButton btnAddANewStudent = new JButton("Add a New Student");
		btnAddANewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				AddNewStudentView addStudentView = new AddNewStudentView(x, y);
				addStudentView.setVisible(true);

			}
		});
		btnAddANewStudent.setBounds(67, 327, 324, 25);
		contentPane.add(btnAddANewStudent);

		JButton btnUpdateStudent = new JButton("Update a Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceAStudentToUpdate choiceStudentUpdate = new ChoiceAStudentToUpdate(x, y);
				choiceStudentUpdate.setVisible(true);

			}
		});
		btnUpdateStudent.setBounds(67, 364, 324, 25);
		contentPane.add(btnUpdateStudent);

		JButton assignStudentCourse = new JButton("Assign Student into Course");
		assignStudentCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				AssignStudentCourse assignStudent = new AssignStudentCourse(x, y);
				assignStudent.setVisible(true);
			}
		});
		assignStudentCourse.setBounds(81, 149, 260, 25);
		contentPane.add(assignStudentCourse);

		JButton deleteCourse = new JButton("Delete a Course");
		deleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ChoiceACourseToDelete courseToDelete = new ChoiceACourseToDelete(x, y);
				courseToDelete.setVisible(true);
			}
		});
		deleteCourse.setBounds(247, 102, 174, 25);
		contentPane.add(deleteCourse);

		JLabel label = new JLabel("___________________________________________________________");
		label.setBounds(45, 186, 392, 15);
		contentPane.add(label);

	}
}
