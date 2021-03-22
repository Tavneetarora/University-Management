package universitymanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.*;

public class AddNewLecturer implements ActionListener {
	JFrame f;
	JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id15, id16, id17, lab, lab1, lab2;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
	JButton b, b1, b2, b3;
	JComboBox c1, c2;

	Random ran = new Random();
	long first4 = (ran.nextLong() % 9000L) + 1000L;
	long first = Math.abs(first4);

	AddNewLecturer() {
		f = new JFrame("Add Lecturer");
		f.setBackground(Color.white);
		f.setLayout(null);

		id15 = new JLabel();
		id15.setBounds(0, 0, 900, 700);
		id15.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("universitymanagement/pics/newlect.jpg"));
		Image i3 = img.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		ImageIcon icc3 = new ImageIcon(i3);
		id15.setIcon(icc3);

		id8 = new JLabel("New Lecturer Details");
		id8.setBounds(320, 5, 500, 50);
		id8.setFont(new Font("serif", Font.ITALIC, 25));
		id8.setForeground(Color.black);
		id15.add(id8);
		f.add(id15);

		id1 = new JLabel("Name");
		id1.setBounds(50, 150, 100, 30);
		id1.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id1);

		t1 = new JTextField();
		t1.setBounds(200, 150, 150, 30);
		id15.add(t1);

		id2 = new JLabel("Father's Name");
		id2.setBounds(400, 150, 200, 30);
		id2.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id2);

		t2 = new JTextField();
		t2.setBounds(600, 150, 150, 30);
		id15.add(t2);

		id3 = new JLabel("Age");
		id3.setBounds(50, 200, 100, 30);
		id3.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id3);

		t3 = new JTextField();
		t3.setBounds(200, 200, 150, 30);
		id15.add(t3);

		id4 = new JLabel("DOB (dd/mm/yyyy)");
		id4.setBounds(400, 200, 200, 30);
		id4.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id4);

		t4 = new JTextField();
		t4.setBounds(600, 200, 150, 30);
		id15.add(t4);

		id5 = new JLabel("Address");
		id5.setBounds(50, 250, 100, 30);
		id5.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id5);

		t5 = new JTextField();
		t5.setBounds(200, 250, 150, 30);
		id15.add(t5);

		id6 = new JLabel("Phone");
		id6.setBounds(400, 250, 100, 30);
		id6.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id6);

		t6 = new JTextField();
		t6.setBounds(600, 250, 150, 30);
		id15.add(t6);

		id7 = new JLabel("Email Id");
		id7.setBounds(50, 300, 100, 30);
		id7.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id7);

		t7 = new JTextField();
		t7.setBounds(200, 300, 150, 30);
		id15.add(t7);

		id8 = new JLabel("Class X(%)");
		id8.setBounds(400, 300, 130, 30);
		id8.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id8);

		t8 = new JTextField();
		t8.setBounds(600, 300, 150, 30);
		id15.add(t8);

		id9 = new JLabel("Class XII(%)");
		id9.setBounds(50, 350, 130, 30);
		id9.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id9);

		t9 = new JTextField();
		t9.setBounds(200, 350, 150, 30);
		id15.add(t9);

		lab = new JLabel("Education");
		lab.setBounds(50, 400, 150, 30);
		lab.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(lab);

		String course[] = { "B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "BA", "BCom" };
		c1 = new JComboBox(course);
		c1.setBackground(Color.WHITE);
		c1.setBounds(200, 400, 150, 30);
		id15.add(c1);

		lab2 = new JLabel("Department");
		lab2.setBounds(400, 350, 150, 30);
		lab2.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(lab2);

		String branch[] = { "Computer Science", "Electronics", "Electrical", "Mechanical", "Civil" };
		c2 = new JComboBox(branch);
		c2.setBackground(Color.WHITE);
		c2.setBounds(600, 350, 150, 30);
		id15.add(c2);

		id11 = new JLabel("Employee id");
		id11.setBounds(400, 400, 150, 30);
		id11.setFont(new Font("serif", Font.BOLD, 20));
		id15.add(id11);

		t11 = new JTextField();
		t11.setText("101" + first);
		t11.setBounds(600, 400, 150, 30);
		id15.add(t11);

		b = new JButton("Submit");
		b.setBackground(Color.WHITE);
		b.setForeground(Color.BLACK);
		b.setBounds(250, 550, 150, 40);

		id15.add(b);

		b1 = new JButton("Cancel");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setBounds(450, 550, 150, 40);

		id15.add(b1);

		b.addActionListener(this);
		b1.addActionListener(this);

		f.setVisible(true);
		f.setSize(920, 680);
		f.setLocation(400, 70);
		f.getContentPane().setBackground(Color.WHITE);
	}

	public void actionPerformed(ActionEvent ae) {

		String a = t1.getText();
		String bb = t2.getText();
		String c = t3.getText();
		String d = t4.getText();
		String e = t5.getText();
		String ff = t6.getText();
		String g = t7.getText();
		String h = t8.getText();
		String i = t9.getText();
		String k = (String) c1.getSelectedItem();
		String l = t11.getText();
		String m = (String) c2.getSelectedItem();
		try {
			if (ae.getSource() == b) {

				if (a.equals("") || bb.equals("") || c.equals("") || d.equals("") || e.equals("") || ff.equals("")
						|| g.equals("") || h.equals("") || i.equals("") || k.equals("") || l.equals("")
						|| m.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter all the details");
				} else {

					Connec cc = new Connec();
					String q = "insert into lecturer values('" + a + "','" + bb + "','" + c + "','" + d + "','" + e
							+ "','" + ff + "','" + g + "','" + h + "','" + i + "','" + k + "','" + l + "','" + m + "')";

					cc.s.executeUpdate(q);

					JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
					f.setVisible(false);

				}

			} else if (ae.getSource() == b1) {
				f.setVisible(false);
				new Homepage().setVisible(true);

			}

		} catch (Exception e1) {
			System.out.println(e1);
		}

	}

	public static void main(String[] arg) {
		new AddNewLecturer().f.setVisible(true);
	}
}
