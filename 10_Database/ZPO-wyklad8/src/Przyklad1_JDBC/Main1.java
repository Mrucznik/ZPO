package Przyklad1_JDBC;

import java.sql.*;

public class Main1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Znaleziono driver bazy");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mysql", "root", "");
			System.out.println("Po³¹czony!!");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Brak drivera");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Brak po³¹czeniea");
			e.printStackTrace();
		}

	}

}
