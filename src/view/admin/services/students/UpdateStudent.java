package view.admin.services.students;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import system.SystemCollege;
import view.util.CheckView;
/*
 * @author thiagomoura21
 */
public class UpdateStudent extends JDialog {

	private static final long serialVersionUID = 1318752742945666961L;

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField address;
	private JTextField nationality;

	public UpdateStudent(int x, int y, int idStudent) {

		setTitle("Update a student");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(63, 14, 56, 19);
		contentPanel.add(lblName);

		name = new JTextField();
		name.setBounds(111, 14, 277, 19);
		contentPanel.add(name);
		name.setColumns(10);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(43, 59, 70, 15);
		contentPanel.add(lblAddress);

		address = new JTextField();
		address.setBounds(111, 57, 277, 19);
		contentPanel.add(address);
		address.setColumns(10);

		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(25, 104, 88, 15);
		contentPanel.add(lblNationality);

		nationality = new JTextField();
		nationality.setBounds(111, 102, 277, 19);
		contentPanel.add(nationality);
		nationality.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canIGo = checkOfInput(name.getText(), address.getText(), nationality.getText());
				if (canIGo) {
					SystemCollege system = SystemCollege.getInstanceSystem();
					system.updateStudent(idStudent, name.getText(), address.getText(), nationality.getText());
					dispose();
				}
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

		SystemCollege system = SystemCollege.getInstanceSystem();
		Map<String, String> mapStudent = system.getStudentDataInMap(idStudent);
		name.setText(mapStudent.get("NAME"));
		address.setText(mapStudent.get("ADDRESS"));
		nationality.setText(mapStudent.get("NATIONALITY"));
	}

	private boolean checkOfInput(String nameString, String addressString, String nationalityString) {

		if (!CheckView.verifyName(nameString)) {
			name.setText("");
			address.setText("");
			nationality.setText("");
			return false;
		} else if (!CheckView.verifyAddress(addressString)) {
			name.setText("");
			address.setText("");
			nationality.setText("");
			return false;
		} else if (!CheckView.verifyNationality(nationalityString)) {
			name.setText("");
			address.setText("");
			nationality.setText("");
			return false;
		} else
			return true;
	}
}
