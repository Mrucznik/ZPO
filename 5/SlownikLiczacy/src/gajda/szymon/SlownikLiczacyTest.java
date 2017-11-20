package gajda.szymon;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SlownikLiczacyTest {
    private String word = "lol";

    @org.junit.Test
    public void sposobA() throws Exception {
        Map<String, Integer> result = new HashMap<>();
        SlownikLiczacy.sposobA(result, word);
        SlownikLiczacy.sposobA(result, word);
        SlownikLiczacy.sposobA(result, word);
        assertEquals(getGoodMap(), result);
    }

    @org.junit.Test
    public void sposobB() throws Exception {
        Map<String, Integer> result = new HashMap<>();
        SlownikLiczacy.sposobB(result, word);
        SlownikLiczacy.sposobB(result, word);
        SlownikLiczacy.sposobB(result, word);
        assertEquals(getGoodMap(), result);
    }

    @org.junit.Test
    public void sposobC() throws Exception {
        Map<String, Integer> result = new HashMap<>();
        SlownikLiczacy.sposobC(result, word);
        SlownikLiczacy.sposobC(result, word);
        SlownikLiczacy.sposobC(result, word);
        assertEquals(getGoodMap(), result);
    }

    @org.junit.Test
    public void sposobD() throws Exception {
        Map<String, Integer> result = new HashMap<>();
        SlownikLiczacy.sposobD(result, word);
        SlownikLiczacy.sposobD(result, word);
        SlownikLiczacy.sposobD(result, word);
        assertEquals(getGoodMap(), result);
    }

    private Map<String, Integer> getGoodMap()
    {
        Map<String, Integer> result = new HashMap<>();
        result.merge(word, 1, Integer::sum);
        result.merge(word, 1, Integer::sum);
        result.merge(word, 1, Integer::sum);
        return result;
    }

}