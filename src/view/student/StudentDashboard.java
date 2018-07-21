package view.student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StudentDashboard extends JFrame {

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
	}

}
