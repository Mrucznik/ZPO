package gajda.szymon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainTest {
    @org.junit.Test
    public void swapWydajnosc() throws Exception {
        ArrayList<Long> l1 = new ArrayList<>();
        LinkedList<Long> l2 = new LinkedList<>();

        for(int i=0; i<10000; i++)
        {
            l1.add(new Random().nextLong());
            l2.add(new Random().nextLong());
        }
        long startTime = System.nanoTime();
        for(int i=0; i<100000; i++)
        {
            Main.swap(l1, new Random().nextInt(10000), new Random().nextInt(10000));
        }
        System.out.println("Czas potrzebny do 100 000 zamian dla ArrayList: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        for(int i=0; i<100000; i++)
        {
            Main.swap(l2, new Random().nextInt(10000), new Random().nextInt(10000));
        }
        System.out.println("Czas potrzebny do 100 000 zamian dla LinkedList: " + (System.nanoTime() - startTime));
    }

    @org.junit.Test
    public void swap() throws Exception {
        ArrayList<Long> l1 = new ArrayList<>();
        l1.add(0L);
        l1.add(1L);

        Main.swap(l1, 0, 1);
        assertEquals(1L, (long)l1.get(0));
        assertEquals(0L, (long)l1.get(1));
    }

    @org.junit.Test
    public void swap2() throws Exception {
        ArrayList<Long> l1 = new ArrayList<>();
        l1.add(0L);
        l1.add(1L);

        Main.swap2(l1, 0, 1);
        assertEquals(1L, (long)l1.get(0));
        assertEquals(0L, (long)l1.get(1));

        LinkedList<Long> l2 = new LinkedList<>();
        l2.add(0L);
        l2.add(1L);
        try {
            Main.swap2(l2, 0, 1);
            fail("Expected an not O(1) exception to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Ta lista nie bsługuje swobodnego dostępu (dostępu do elementu o dowolnym indeksie i w czase O(1))."));
        }
    }

}