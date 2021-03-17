package universitymanagement;

import java.sql.*;

public class Connec {
	Connection c;
	Statement s;

	public Connec() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///um", "root", "");
			s = c.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
