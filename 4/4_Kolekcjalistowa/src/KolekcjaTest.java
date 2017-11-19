import com.google.common.collect.ComparisonChain;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class KolekcjaTest {
    ArrayList<Student> sortedStudents;

    @Before
    public void setUp() throws Exception {
        sortedStudents = new ArrayList<>();
        sortedStudents.add(new Student("Szymon", "Gajda", new Date(1994, 11, 3), 1.888));
        sortedStudents.add(new Student("Arnold", "Pajda", new Date(1994, 11, 3), 1.444));
        sortedStudents.add(new Student("Arnold", "Pajda", new Date(1994, 11, 3), 1.05));
        sortedStudents.add(new Student("Szymon", "Gajda", new Date(1995, 11, 3), 1.95));
        sortedStudents.add(new Student("Szymon", "Gajda", new Date(1995, 11, 3), 1.60));
        sortedStudents.add(new Student("Arnold", "Pajda", new Date(1995, 11, 3), 1.85));
    }

    @org.junit.Test
    public void sortGuava() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Szymon", "Gajda", new Date(1995, 11, 3), 1.60));
        students.add(new Student("Szymon", "Gajda", new Date(1994, 11, 3), 1.888));
        students.add(new Student("Arnold", "Pajda", new Date(1995, 11, 3), 1.85));
        students.add(new Student("Arnold", "Pajda", new Date(1994, 11, 3), 1.444));
        students.add(new Student("Szymon", "Gajda", new Date(1995, 11, 3), 1.95));
        students.add(new Student("Arnold", "Pajda", new Date(1994, 11, 3), 1.05));

        students.sort((s1, s2) -> {
            int result = Integer.compare(s1.dataUrodzenia.getYear(), s2.dataUrodzenia.getYear());
            if(result == 0) {
                result = Character.compare(s1.nazwisko.charAt(0), s2.nazwisko.charAt(0));
                if(result == 0) {
                    result = Double.compare(s1.wzrost, s2.wzrost)*-1;
                }
            }
            return result;
        });

        System.out.println(students.toString());

        assertArrayEquals(sortedStudents.toArray(), students.toArray());
    }

    @org.junit.Test
    public void sortJDK() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Szymon", "Gajda", new Date(1995, 11, 3), 1.60));
        students.add(new Student("Szymon", "Gajda", new Date(1994, 11, 3), 1.888));
        students.add(new Student("Arnold", "Pajda", new Date(1995, 11, 3), 1.85));
        students.add(new Student("Arnold", "Pajda", new Date(1994, 11, 3), 1.444));
        students.add(new Student("Szymon", "Gajda", new Date(1995, 11, 3), 1.95));
        students.add(new Student("Arnold", "Pajda", new Date(1994, 11, 3), 1.05));

        students.sort((s1, s2) -> {
            return ComparisonChain.start()
                    .compare(s1.dataUrodzenia.getYear(), s2.dataUrodzenia.getYear())
                    .compare(s1.nazwisko.charAt(0), s2.nazwisko.charAt(0))
                    .compare(s2.wzrost, s1.wzrost)
                    .result();
        });

        System.out.println(students.toString());

        assertArrayEquals(sortedStudents.toArray(), students.toArray());
    }

}