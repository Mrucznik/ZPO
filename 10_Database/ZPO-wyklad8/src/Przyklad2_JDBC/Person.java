package Przyklad2_JDBC;
import java.sql.*;
public class Person {
	public Person(String imie, String nazwisko, String pesel, int wiek,
			Date dataZapisu) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.wiek = wiek;
		this.dataZapisu = dataZapisu;
	}
	private String imie;
	private String nazwisko;
	private String pesel;
	private int wiek;
	private Date dataZapisu;
	public String getImie() {
		return imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public String getPesel() {
		return pesel;
	}
	public int getWiek() {
		return wiek;
	}
	public Date getDataZapisu() {
		return dataZapisu;
	}
	public String toString() {
		return "Person [imie=" + imie + ", nazwisko=" + nazwisko + ", pesel="
				+ pesel + ", wiek=" + wiek + ", dataZapisu=" + dataZapisu + "]";
	}
	public static int addPerson(Connection con, Person p) throws SQLException {
		  PreparedStatement ps = null;
		  try{
		    ps = con.prepareStatement("INSERT INTO PERSONS (PESEL, IMIE, NAZWISKO, WIEK, DATA_ZAPISU) VALUES (?,?,?,?,?)");
		    ps.setString(1, p.getPesel());
		    ps.setString(2, p.getImie());
		    ps.setString(3, p.getNazwisko());
		    ps.setInt(4, p.getWiek());
		    ps.setDate(5, p.getDataZapisu());
		    return ps.executeUpdate();
		  } finally
		  {
		    if (ps != null)
		      ps.close();
		  }
		}
}
