import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

public class Student {
    protected String imie;
    protected String nazwisko;
    protected Date dataUrodzenia;
    protected double wzrost;

    public Student(String imie, String nazwisko, Date dataUrodzenia, double wzrost) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.wzrost = wzrost;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia.getYear() +
                ", wzrost=" + wzrost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (Double.compare(student.wzrost, wzrost) != 0) return false;
        if (imie != null ? !imie.equals(student.imie) : student.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(student.nazwisko) : student.nazwisko != null) return false;
        return dataUrodzenia != null ? dataUrodzenia.equals(student.dataUrodzenia) : student.dataUrodzenia == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = imie != null ? imie.hashCode() : 0;
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (dataUrodzenia != null ? dataUrodzenia.hashCode() : 0);
        temp = Double.doubleToLongBits(wzrost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
