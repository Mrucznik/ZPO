package Przyklad1_JDBC;
import java.sql.*;
public class Main2 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mysql", "root", "");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM user;");
		while (rs.next()) {
			String s1 = rs.getString("User");
			String s2 = rs.getString("Host");
			System.out.println(s1 + " " + s2);
		}
	}

}
