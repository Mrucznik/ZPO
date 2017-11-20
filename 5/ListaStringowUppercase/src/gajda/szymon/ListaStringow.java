package gajda.szymon;

import java.util.ArrayList;
import java.util.ListIterator;

class ListaStringow {
    static ArrayList<String> sposob1(ArrayList<String> list)
    {
        ListIterator<String> i = list.listIterator();
        while(i.hasNext())
        {
            String s =  i.next();
            i.set(s.toUpperCase());
        }
        return list;
    }

    static ArrayList<String> sposob2(ArrayList<String> list)
    {
        for(int i=0; i<list.size(); i++)
        {
            list.set(i, list.get(i).toUpperCase());
        }
        return list;
    }

    static ArrayList<String> sposob3(ArrayList<String> list)
    {
        list.replaceAll(String::toUpperCase);
        return list;
    }
}
