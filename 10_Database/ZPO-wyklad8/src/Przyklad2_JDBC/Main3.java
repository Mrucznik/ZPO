package Przyklad2_JDBC;
import java.util.Date;
import java.sql.*;
public class Main3 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		
		long d = new Date().getTime();
		Person p = new Person("Jan","Nowak","95023207841",25,new java.sql.Date(d));
		Person.addPerson(conn,p);
	}
	

}
