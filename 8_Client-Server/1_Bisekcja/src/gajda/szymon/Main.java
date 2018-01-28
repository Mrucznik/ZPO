package gajda.szymon;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Double> list = new ArrayList<Double>();

        for(double i=-4; i<0; i+=0.001)
        {
            list.add(i);
        }

        List<Double> transform = Lists.transform(list, Main::f2);


        int idx = Collections.binarySearch(transform, 0.001);
        System.out.println("IDX: " + list.get(-idx));
    }

    static int i = 0;

    public static double f2(double x)
    {
        return Math.pow(x,2) - 4;
    }

    public static double f1(double x)
    {
        return 5*Math.pow(x, 3) + 2*Math.pow(x,2) + (-10*x)+1;
    }

    public static double bisection()
    {
        return 8.7;
    }
}
