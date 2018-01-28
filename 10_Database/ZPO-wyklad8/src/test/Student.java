package test;

public class Student {
	public Student(String imie, String nazwisko, int nrAlbumu, float ocena,
			boolean stacjonarny) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrAlbumu = nrAlbumu;
		this.ocena = ocena;
		this.stacjonarny = stacjonarny;
	}
	public Student(){}
	long id;
	String imie;
	String nazwisko;
	int nrAlbumu;	
	float ocena;
	boolean stacjonarny;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getNrAlbumu() {
		return nrAlbumu;
	}
	public void setNrAlbumu(int nrAlbumu) {
		this.nrAlbumu = nrAlbumu;
	}
	public float getOcena() {
		return ocena;
	}
	public void setOcena(float ocena) {
		this.ocena = ocena;
	}
	public boolean isStacjonarny() {
		return stacjonarny;
	}
	public void setStacjonarny(boolean stacjonarny) {
		this.stacjonarny = stacjonarny;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", imie=" + imie + ", nazwisko="
				+ nazwisko + ", nrAlbumu=" + nrAlbumu + ", ocena=" + ocena
				+ ", stacjonarny=" + stacjonarny + "]";
	}
}
