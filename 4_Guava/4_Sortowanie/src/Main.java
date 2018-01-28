import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] names = {"Łukasz", "Ścibor", "Stefania", "Bolek", "Agnieszka", "Zyta", "Órszula"};
        String[] correct =  {"Agnieszka", "Bolek", "Łukasz", "Órszula", "Stefania", "Ścibor", "Zyta"};
        Main.sortStrings(Collator.getInstance(new Locale("pl")), names);
    }

    public static void sortStrings(Collator collator, String[] words) {
        //Bubble sort
        int n = words.length;
        do {
            int swaps= 0;
            for (int i = 0; i < n-1; i++) {
                if(collator.compare(words[i], words[i+1]) > 0) {
                    //Swap elements
                    String tmp = words[i];
                    words[i] = words[i+1];
                    words[i+1] = tmp;
                    ++swaps;
                }
            }
            if(swaps == 0)
                break;
            --n;
        } while (n > 1);
    }

    public static void fastSortStrings(Collator collator, String[] words) {
        Arrays.sort(words, collator);
    }

    public static void fastSortStrings2(Collator collator, String[] words) {
        Arrays.sort(words, collator::compare);
    }
}
