package Przyklad2_JDBC;
import java.sql.*;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

		Scanner sc = new Scanner(System.in);
		conn.setAutoCommit(false);
		for(int i = 0;i<10;i++)
		{
			long d = new java.util.Date().getTime();
			Person p = new Person("Jan"+i,"Nowak"+i,"9502320784"+i,25+i,new Date(d));
			System.out.println("dodaæ osobê t/n?");
			if(sc.next().equals("t"))
				Person.addPerson(conn,p);
			else
			{
				conn.rollback();
			System.out.println("rollback");
			return;
			}
		}
		conn.commit();
		System.out.println("OK");
	}
}
