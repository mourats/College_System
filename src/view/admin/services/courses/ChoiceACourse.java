package view.admin.services.courses;

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
/*
 * @author thiagomoura21
 */
public class ChoiceACourse extends JDialog {

	private static final long serialVersionUID = -5480164608385519360L;

	private final JPanel contentPanel = new JPanel();
	private JTextField idCourse;

	public ChoiceACourse(int x, int y) {
		setTitle("Student in a course");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 250, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNameCourse = new JLabel("ID Course:");
		lblNameCourse.setBounds(12, 12, 110, 15);
		contentPanel.add(lblNameCourse);

		idCourse = new JTextField();
		idCourse.setBounds(34, 44, 169, 19);
		contentPanel.add(idCourse);
		idCourse.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canIGo = checkOfInput(idCourse.getText());
				if (canIGo) {
					SystemCollege system = SystemCollege.getInstanceSystem();
					int id = Integer.parseInt(idCourse.getText());
					JOptionPane.showMessageDialog(null, system.getStudentsInCourse(id), "Students in Course",
							JOptionPane.INFORMATION_MESSAGE);
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

	private boolean checkOfInput(String idCourseString) {

		if (!CheckView.verifyIdCourseEmpty(idCourseString)) {
			idCourse.setText("");
			return false;
		} else if (!CheckView.verifyIdCourseIsNumber(idCourseString)) {
			idCourse.setText("");
			return false;
		}
		if (!CheckView.verifyIdCourseExist(idCourseString)) {
			idCourse.setText("");
			return false;
		} else
			return true;
	}
}
