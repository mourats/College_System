package view.admin.students;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import system.SystemCollege;

public class AddNewStudentView extends JDialog {

	private static final long serialVersionUID = 4589178736602263555L;

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField address;
	private JTextField nationality;

	/**
	 * Create the dialog.
	 */
	public AddNewStudentView(int x, int y) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 350, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNameCourse = new JLabel("Name:");
			lblNameCourse.setBounds(32, 14, 56, 19);
			contentPanel.add(lblNameCourse);
		}
		{
			name = new JTextField();
			name.setBounds(86, 12, 252, 19);
			contentPanel.add(name);
			name.setColumns(10);
		}

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(18, 59, 70, 15);
		contentPanel.add(lblAddress);

		address = new JTextField();
		address.setBounds(86, 57, 252, 19);
		contentPanel.add(address);
		address.setColumns(10);

		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(0, 104, 88, 15);
		contentPanel.add(lblNationality);

		nationality = new JTextField();
		nationality.setBounds(86, 102, 252, 19);
		contentPanel.add(nationality);
		nationality.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemCollege system = SystemCollege.getInstanceSystem();
				// validar.
				String login = system.addNewStudent(name.getText(), address.getText(), nationality.getText());
				JOptionPane.showMessageDialog(null, login, "Login Information", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}
}
