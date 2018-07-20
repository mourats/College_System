package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewFirstScreen extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		addMyModel();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFirstScreen frame = new ViewFirstScreen(100, 100);
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
	public ViewFirstScreen(int x, int y) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				ViewLoginStudent viewLogin = new ViewLoginStudent(x, y);
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
	
	private static void addMyModel() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

}
