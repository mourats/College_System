package view.admin;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import system.SystemCollege;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 6244993357481124230L;
	
	private JPanel contentPane;
	private SystemCollege system;
	
	/**
	 * Create the frame.
	 * @param system 
	 */
	public AdminDashboard(int x, int y, SystemCollege system) {
		
		system = SystemCollege.getInstanceSystem();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Administrator");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(143, 12, 171, 41);
		contentPane.add(lblTitle);
	}

}
