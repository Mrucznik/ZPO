package gajda.szymon;

import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListaStringowTest {

    public static void main(String[] args) {
        Assert.assertEquals(getUpperList(), ListaStringow.sposob1(getList()));
        Assert.assertEquals(getUpperList(),ListaStringow.sposob2(getList()));
        Assert.assertEquals(getUpperList(),ListaStringow.sposob3(getList()));
    }

    private static ArrayList<String> getList()
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("czEsc");
        list.add("elo");
        list.add("Hi");
        list.add("04t34");
        return list;
    }

    private static ArrayList<String> getUpperList()
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("CZESC");
        list.add("ELO");
        list.add("HI");
        list.add("04T34");
        return list;
    }
}