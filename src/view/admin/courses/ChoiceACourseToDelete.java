package view.admin.courses;

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

import system.SystemCollege;

public class ChoiceACourseToDelete extends JDialog {

	private static final long serialVersionUID = -7404121456948478472L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField idCourse;

	/**
	 * Create the dialog.
	 */
	public ChoiceACourseToDelete(int x, int y) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 250, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNameCourse = new JLabel("ID Course:");
			lblNameCourse.setBounds(12, 12, 110, 15);
			contentPanel.add(lblNameCourse);
		}
		{
			idCourse = new JTextField();
			idCourse.setBounds(34, 44, 169, 19);
			contentPanel.add(idCourse);
			idCourse.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SystemCollege system = SystemCollege.getInstanceSystem();
						int id = Integer.parseInt(idCourse.getText());
						system.deleteCourse(id);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
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
	}
}
