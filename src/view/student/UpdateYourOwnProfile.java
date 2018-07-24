package view.student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import system.SystemCollege;
import view.util.CheckView;

public class UpdateYourOwnProfile extends JDialog {

	private static final long serialVersionUID = -63640605408833197L;

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField address;
	private JTextField nationality;
	private JTextField userName;
	private JPasswordField password;

	public UpdateYourOwnProfile(int x, int y) {

		setTitle("Update your own profile");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 400, 300);
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

		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(25, 146, 88, 15);
		contentPanel.add(lblUserName);

		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(111, 144, 277, 19);
		contentPanel.add(userName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(25, 190, 80, 15);
		contentPanel.add(lblPassword);

		password = new JPasswordField();
		password.setBounds(111, 188, 277, 19);
		contentPanel.add(password);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwordText = new String(password.getPassword()).trim();
				boolean canIGo = checkOfInput(name.getText(), address.getText(), nationality.getText(),
						userName.getText(), passwordText);
				if (canIGo) {
					SystemCollege system = SystemCollege.getInstanceSystem();
					system.updateStudentOwnProfile(name.getText(), address.getText(), nationality.getText(),
							userName.getText(), passwordText);
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
	}

	private boolean checkOfInput(String nameString, String addressString, String nationalityString,
			String userNameString, String passwordString) {

		if (!CheckView.verifyName(nameString)) {
			clearTextFields();
			return false;
		} else if (!CheckView.verifyAddress(addressString)) {
			clearTextFields();
			return false;
		} else if (!CheckView.verifyNationality(nationalityString)) {
			clearTextFields();
			return false;
		} else if (!CheckView.verifyUsername(userNameString)) {
			clearTextFields();
			return false;
		} else if (!CheckView.verifyPassword(passwordString)) {
			clearTextFields();
			return false;
		} else
			return true;
	}

	private void clearTextFields() {
		name.setText("");
		address.setText("");
		nationality.setText("");
		userName.setText("");
		password.setText("");
	}
}
