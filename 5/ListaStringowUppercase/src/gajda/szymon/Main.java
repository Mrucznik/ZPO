package gajda.szymon;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        System.out.println(sposob1(getList()));
        System.out.println(sposob2(getList()));
        System.out.println(sposob3(getList()));
    }

    private static ArrayList<String> getList()
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("czEcs");
        list.add("elo");
        list.add("Hi");
        list.add("04t34");
        return list;
    }

    public static ArrayList<String> sposob1(ArrayList<String> list)
    {
        ListIterator<String> i = list.listIterator();
        while(i.hasNext())
        {
            String s =  i.next();
            i.set(s.toUpperCase());
        }
        return list;
    }

    public static ArrayList<String> sposob2(ArrayList<String> list)
    {
        for(int i=0; i<list.size(); i++)
        {
            list.set(i, list.get(i).toUpperCase());
        }
        return list;
    }

    public static ArrayList<String> sposob3(ArrayList<String> list)
    {
        list.replaceAll(String::toUpperCase);
        return list;
    }
}
