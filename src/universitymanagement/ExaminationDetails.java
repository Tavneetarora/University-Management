package universitymanagement;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener {
	private JPanel panel;
	private JTable table;
	private JTextField rno;
	private JButton b1, b2, b3;

	public void Book() {
		try {
			Connec con = new Connec();
			String sql = "select * from student";
			PreparedStatement st = con.c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			st.close();
			con.c.close();
		} catch (Exception e) {
		}

	}

	public ExaminationDetails() {

		setBounds(250, 100, 930, 475);

		panel = new JPanel();
		panel.setBackground(new Color(250,240,250));

		setContentPane(panel); //contentpane

		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 133, 1080, 282);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				rno.setText(table.getModel().getValueAt(row, 9).toString());
			}
		});

		//table.setBackground(new Color(240, 248, 255));
		table.setBackground(Color.PINK);
		table.setForeground(Color.DARK_GRAY);
		//table.setForeground(Color.ORANGE);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);

		b1 = new JButton("Result");
		b1.addActionListener(this);
		b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
		b1.setForeground(new Color(199, 21, 133));
		b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b1.setBounds(564, 89, 138, 33);
		panel.add(b1);

		JLabel l1 = new JLabel("CLICK ON THE STUDENT RECORD TO SEE RESULTS");
		l1.setForeground(new Color(107, 142, 35));
		l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		l1.setBounds(250, 15, 800, 47);
		panel.add(l1);

		rno = new JTextField();
		rno.setBackground(new Color(255, 240, 245));
		rno.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
		rno.setForeground(new Color(47, 79, 79));
		rno.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		rno.setBounds(189, 89, 357, 33);
		panel.add(rno);
		rno.setColumns(10);

		JLabel l3 = new JLabel("<--Back");
		l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Homepage().setVisible(true);
				setVisible(false);
			}
		});
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		l3.setBounds(97, 89, 72, 33);
		panel.add(l3);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel1.setBounds(47, 54, 1100, 368);
		panel.add(panel1);
		panel1.setBackground(Color.WHITE);
		Book();
		setSize(1200, 500);
		
		
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			Connec con = new Connec();
			if (ae.getSource() == b1) {
				if(rno.getText().equals(""))
				{
				JOptionPane.showMessageDialog(null, "Click on the student record whose result you want to see");
				}
				else
				{
				new ShowResult(rno.getText()).setVisible(true);
				this.setVisible(false);
				}
			}
			}
		catch (Exception e) {
		}
		
	}

	public static void main(String[] args) {
		new ExaminationDetails().setVisible(true);
	}
}
