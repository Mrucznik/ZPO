package gajda.szymon;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String imie;
    private String nazwisko;
    private int nrIndeksu;
    private List<Integer> listaOcen;

    public Student(String imie, String nazwisko, int nrIndeksu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;

        listaOcen = new ArrayList<Integer>();
    }

    public void dodajOcene(Integer ocena)
    {
        listaOcen.add(ocena);
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrIndeksu=" + nrIndeksu +
                ", listaOcen=" + listaOcen +
                '}';
    }
}
