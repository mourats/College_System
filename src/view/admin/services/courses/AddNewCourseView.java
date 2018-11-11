package view.admin.services.courses;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import system.SystemCollege;
import view.util.CheckView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
/*
 * @author thiagomoura21
 */
public class AddNewCourseView extends JDialog {

	private static final long serialVersionUID = 8716967657439627552L;

	private final JPanel contentPanel = new JPanel();
	private JTextField nameCourse;

	public AddNewCourseView(int x, int y) {
		setTitle("Add a new course");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 250, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNameCourse = new JLabel("Name Course:");
		lblNameCourse.setBounds(12, 12, 110, 15);
		contentPanel.add(lblNameCourse);

		nameCourse = new JTextField();
		nameCourse.setBounds(34, 44, 169, 19);
		contentPanel.add(nameCourse);
		nameCourse.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemCollege system = SystemCollege.getInstanceSystem();

				boolean canIgo = checkOfInput(nameCourse.getText().trim());
				if (canIgo) {
					system.addNewCourse(nameCourse.getText());
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

	private boolean checkOfInput(String nameString) {

		if (!CheckView.verifyName(nameString)) {
			nameCourse.setText("");
			return false;
		} else
			return true;
	}
}
