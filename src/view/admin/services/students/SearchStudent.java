package view.admin.services.students;

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
import view.util.CheckView;

public class SearchStudent extends JDialog {

	private static final long serialVersionUID = -307654772388652262L;

	private final JPanel contentPanel = new JPanel();
	private JTextField nameStudent;

	public SearchStudent(int x, int y) {
		setTitle("Student to update");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 250, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNameStudent = new JLabel("Name Student:");
		lblNameStudent.setBounds(12, 12, 110, 15);
		contentPanel.add(lblNameStudent);

		nameStudent = new JTextField();
		nameStudent.setBounds(34, 44, 169, 19);
		contentPanel.add(nameStudent);
		nameStudent.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canIGo = checkOfInput(nameStudent.getText());
				if(canIGo) {
				SystemCollege system = SystemCollege.getInstanceSystem();
				JOptionPane.showMessageDialog(null, system.getStudentByName(nameStudent.getText()), "Student",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}}
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
	
	private boolean checkOfInput(String nameString) {

		if (!CheckView.verifyName(nameString)) {
			nameStudent.setText("");
			return false;
		} else
			return true;
	}
}
