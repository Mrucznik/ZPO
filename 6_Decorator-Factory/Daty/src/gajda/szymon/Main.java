package gajda.szymon;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main {
    public static void main(String[] args) {

        LocalDate warIIstart = LocalDate.of(1939, 9, 1);
        LocalDate warIIend = LocalDate.of(1945, 5, 8);
        Period warTime = Period.between(warIIstart, warIIend.plusDays(1));
        System.out.println("Minęlo: " + warTime.getYears() + " lat " + warTime.getMonths() + " miesięcy i " + warTime.getDays() + " dni.");

        LocalDate urodziny = LocalDate.of(1996, 2, 13);
        System.out.println("Ile 29 lutych: " + ilePrzesteepnych(urodziny, LocalDate.now()));

    }

    public static int ilePrzesteepnych(LocalDate begin, LocalDate end)
    {
        int count = 0;
        for (int i = begin.getYear(); i <= LocalDate.now().getYear(); i++)
        {
            if (i % 4 == 0)
            {
                if (i == begin.getYear() && begin.getMonth().getValue() <= Month.FEBRUARY.getValue())
                {
                    count++;
                }
                else if ( i == end.getYear() && (end.getMonth().getValue() > Month.FEBRUARY.getValue() || (end.getMonth() == Month.FEBRUARY && end.getDayOfMonth() == 29)))
                {
                    count++;
                }
                else if (i != begin.getYear() && i != end.getYear()) {
                    count++;
                }
            }
        }
        return count;
    }
}