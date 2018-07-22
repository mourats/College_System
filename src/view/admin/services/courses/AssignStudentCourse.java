package view.admin.services.courses;

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

public class AssignStudentCourse extends JDialog {

	private static final long serialVersionUID = -1586021753989244698L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField idCourse;
	private JTextField idStudent;

	/**
	 * Create the dialog.
	 */
	public AssignStudentCourse(int x, int y) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(x + 150, y + 100, 250, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNameCourse = new JLabel("ID Course:");
			lblNameCourse.setBounds(12, 41, 85, 15);
			contentPanel.add(lblNameCourse);
	
			idCourse = new JTextField();
			idCourse.setBounds(100, 39, 124, 19);
			contentPanel.add(idCourse);
			idCourse.setColumns(10);
		}
		{
			JLabel lblIdStudent = new JLabel("ID Student:");
			lblIdStudent.setBounds(12, 87, 80, 15);
			contentPanel.add(lblIdStudent);
		}
		{
			idStudent = new JTextField();
			idStudent.setBounds(100, 85, 124, 19);
			contentPanel.add(idStudent);
			idStudent.setColumns(10);
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
						int idStu = Integer.parseInt(idStudent.getText());
						int idCou = Integer.parseInt(idCourse.getText());
						system.setStudentInCourse(idStu, idCou);
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
