package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewFirstScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFirstScreen frame = new ViewFirstScreen();
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
	public ViewFirstScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ViewLoginStudent viewLogin = new ViewLoginStudent(x,y);
				dispose();
				viewLogin.setVisible(true);
				
			}
		});
		btnStudent.setBounds(281, 35, 131, 25);
		contentPane.add(btnStudent);
		
		JButton btnAdminstra = new JButton("Administrator");
		btnAdminstra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdminstra.setBounds(281, 87, 131, 25);
		contentPane.add(btnAdminstra);
		
		JButton btnCreateAdmin = new JButton("Create Admin");
		btnCreateAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateAdmin.setBounds(28, 214, 140, 20);
		contentPane.add(btnCreateAdmin);
	}

}
