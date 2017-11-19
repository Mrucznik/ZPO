import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;

import static org.junit.Assert.*;

public class SplitterTest {
    @org.junit.Test
    public void splitTest1() throws Exception {
        List<String> strings = Lists.newArrayList(Splitter.fixedLength(3).split("Ala ma kota"));
        List<String> myStrings = MySplitter.split("Ala ma kota", 3);

        assertArrayEquals(strings.toArray(), myStrings.toArray());
        System.out.println(myStrings.toString());
    }


    @org.junit.Test
    public void splitTest2() throws Exception {
        List<String> strings = Lists.newArrayList(Splitter.fixedLength(2).split("abcd"));
        List<String> myStrings = MySplitter.split("abcd", 2);

        assertArrayEquals(strings.toArray(), myStrings.toArray());
        System.out.println(myStrings.toString());
    }
}