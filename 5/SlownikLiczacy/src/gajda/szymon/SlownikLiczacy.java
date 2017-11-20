package gajda.szymon;

import java.util.Map;

class SlownikLiczacy {
    static void sposobA(Map<String, Integer> map, String word)
    {
        map.put(word, (map.containsKey(word)) ? map.get(word)+1 : 1);
    }

    static void sposobB(Map<String, Integer> map, String word)
    {
        map.put(word, (map.get(word) != null) ? map.get(word)+1 : 1);
    }

    static void sposobC(Map<String, Integer> map, String word)
    {
        map.put(word, map.getOrDefault(word, 0)+1);
    }

    static void sposobD(Map<String, Integer> map, String word)
    {
        Integer result = map.putIfAbsent(word, 1);
        if(result != null)
            map.put(word, result+1);
    }
}
