package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLoginStudent extends JFrameWithMyModel  {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public ViewLoginStudent(int x, int y) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(159, 159, 135, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(159, 205, 117, 25);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("<-");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = getX();
				int y = getY();
				ViewFirstScreen viewFirst = new ViewFirstScreen(x, y);
				dispose();
				viewFirst.setVisible(true);
			}
		});
		btnBack.setBounds(12, 0, 49, 25);
		contentPane.add(btnBack);
	}
}
