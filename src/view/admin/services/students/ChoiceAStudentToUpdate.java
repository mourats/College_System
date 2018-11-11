package view.admin.services.students;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.util.CheckView;
/*
 * @author thiagomoura21
 */
public class ChoiceAStudentToUpdate extends JDialog {

	private static final long serialVersionUID = -998004536796369380L;

	private final JPanel contentPanel = new JPanel();
	private JTextField idStudent;

	public ChoiceAStudentToUpdate(int x, int y) {
		setTitle("Student to update");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 250, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNameCourse = new JLabel("ID Student:");
		lblNameCourse.setBounds(12, 12, 110, 15);
		contentPanel.add(lblNameCourse);

		idStudent = new JTextField();
		idStudent.setBounds(34, 44, 169, 19);
		contentPanel.add(idStudent);
		idStudent.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canIGo = checkOfInput(idStudent.getText());
				if (canIGo) {
					int id = Integer.parseInt(idStudent.getText());
					UpdateStudent updateStudentView = new UpdateStudent(getX(), getY(), id);
					dispose();
					updateStudentView.setVisible(true);
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

	private boolean checkOfInput(String idStudentString) {

		if (!CheckView.verifyIdStudentEmpty(idStudentString)) {
			idStudent.setText("");
			return false;
		} else if (!CheckView.verifyIdStudentIsNumber(idStudentString)) {
			idStudent.setText("");
			return false;
		} else if (!CheckView.verifyIdStudentExist(idStudentString)) {
			idStudent.setText("");
			return false;

		} else
			return true;
	}
}
