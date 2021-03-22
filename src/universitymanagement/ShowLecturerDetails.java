package universitymanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ShowLecturerDetails extends JFrame implements ActionListener {
	JLabel l1, l2, l3;
	JTable t1;
	JButton b1, b2, b3;
	JTextField t2;
	String x[] = { "Name", "Father's Name", "Age", "Date of Birth", "Address", "Phone", "Email", "Class X(%)",
			"Class XII(%)", "Course", "Department", "Employee Id" };
	String y[][] = new String[20][13];
	int i = 0, j = 0;

	ShowLecturerDetails() {
		super("Lecturer Details");
		setSize(1260, 650);
		setLocation(200, 50);
		setLayout(null);

		l1 = new JLabel("Enter Employee Id to delete Lecturer : ");
		l1.setBounds(50, 360, 400, 30);
		l1.setFont(new Font("serif", Font.BOLD, 20));
		add(l1);

		t2 = new JTextField();
		t2.setBounds(400, 360, 200, 30);
		add(t2);

		b1 = new JButton("Delete");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(620, 360, 100, 30);
		add(b1);

		l2 = new JLabel("Add New Lecturer");
		l2.setBounds(50, 450, 400, 30);
		l2.setFont(new Font("serif", Font.BOLD, 20));
		add(l2);

		b2 = new JButton("Add");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(300, 450, 150, 30);
		add(b2);

		l3 = new JLabel("Update Lecturer Details");
		l3.setBounds(50, 490, 400, 30);
		l3.setFont(new Font("serif", Font.BOLD, 20));
		add(l3);

		b3 = new JButton("Update");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(300, 490, 150, 30);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		try {
			Connec c1 = new Connec();
			String s1 = "select * from lecturer";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				y[i][j++] = rs.getString("name");
				y[i][j++] = rs.getString("fathers_name");
				y[i][j++] = rs.getString("age");
				y[i][j++] = rs.getString("dob");
				y[i][j++] = rs.getString("address");
				y[i][j++] = rs.getString("phone");
				y[i][j++] = rs.getString("email");
				y[i][j++] = rs.getString("class_x");
				y[i][j++] = rs.getString("class_xii");
				y[i][j++] = rs.getString("educational_qualification");
				y[i][j++] = rs.getString("department");
				y[i][j++] = rs.getString("employee_id");
				i++;
				j = 0;
			}
			t1 = new JTable(y, x);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(20, 20, 1200, 330);
		add(sp);

		getContentPane().setBackground(Color.WHITE);

		//b1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		

		if (ae.getSource() == b1) {
			
			Connec c1 = new Connec();
			
			if (t2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Enter the Employee Id");
			}

			else {
				try {
					
					String a = t2.getText();
					String q1 = "select * from lecturer where employee_id= '" + a + "'";
					ResultSet rs = c1.s.executeQuery(q1);
					
					
					if (rs.next()) {
						
						String q = "delete from lecturer where employee_id = '" + a + "'";
						c1.s.executeUpdate(q);
						this.setVisible(false);
						new ShowLecturerDetails().setVisible(true);

					}

					else {
						JOptionPane.showMessageDialog(null, "Employee Id is incorrect");
					}
					
				}
				
			catch (Exception e) {
				}
				
			} 
		}
			
		else if (ae.getSource() == b2) {
			new AddNewLecturer().f.setVisible(true);
			this.setVisible(false);
		} else if (ae.getSource() == b3) {
			new UpdateLecturerRecord().f.setVisible(true);
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new ShowLecturerDetails().setVisible(true);
	}
}
