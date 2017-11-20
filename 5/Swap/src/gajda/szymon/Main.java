package gajda.szymon;

import java.util.List;
import java.util.RandomAccess;

public class Main {
    public static <T> void swap(List<T> list, int i, int j)
    {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static <T> void swap2(List<T> list, int i, int j) throws Exception {
        if( !(list instanceof RandomAccess))
            throw new Exception("Ta lista nie bsługuje swobodnego dostępu (dostępu do elementu o dowolnym indeksie i w czase O(1)).");

        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
