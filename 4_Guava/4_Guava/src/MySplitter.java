import com.sun.istack.internal.NotNull;
import java.util.LinkedList;

public class MySplitter {
    public static LinkedList<String> split(@NotNull String s, int length) throws IllegalAccessException {
        if(s.length() <= 0)
            throw new IllegalAccessException("String cannot be empty.");

        LinkedList<String> strings = new LinkedList<>();
        for(int i=0; i<s.length(); i+=length) {
            strings.add(s.substring(i, Math.min(s.length(), i+length)));
        }
        return strings;
    }
}
