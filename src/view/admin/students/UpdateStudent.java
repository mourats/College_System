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

public class UpdateStudent extends JDialog {

	private static final long serialVersionUID = 1318752742945666961L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField address;
	private JTextField nationality;

	/**
	 * Create the dialog.
	 */
	public UpdateStudent(int x, int y, int idStudent) {
		
		SystemCollege system = SystemCollege.getInstanceSystem();
		JOptionPane.showMessageDialog(null, system.getPerfilStudentById(idStudent), "Student", JOptionPane.INFORMATION_MESSAGE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			name = new JTextField();
			name.setBounds(86, 10, 302, 19);
			contentPanel.add(name);
			name.setColumns(10);
		}

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 56, 70, 15);
		contentPanel.add(lblAddress);

		address = new JTextField();
		address.setBounds(86, 54, 302, 19);
		contentPanel.add(address);
		address.setColumns(10);

		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(0, 97, 88, 15);
		contentPanel.add(lblNationality);

		nationality = new JTextField();
		nationality.setBounds(86, 95, 302, 19);
		contentPanel.add(nationality);
		nationality.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(27, 12, 55, 15);
		contentPanel.add(lblName);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemCollege system = SystemCollege.getInstanceSystem();
				// validar.
				system.updateStudent(idStudent, name.getText(), address.getText(), nationality.getText());
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
