package gajda.szymon;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try {
            Integer[] results = Files.lines(Paths.get("dane.txt"), Charset.forName("Cp1252"))
                    .filter(line -> line.contains("PL"))
                    .map(string -> string.split(" ")[3])
                    .map(Integer::valueOf)
                    .sorted(Integer::compare)
                    .peek(System.out::println)
                    .toArray(Integer[]::new);

            if(results.length < 2)
                System.out.println("Błąd: za mało rekordów aby wyświetlić!");
            else
                System.out.println("Suma max: " + (results[results.length-1]+results[results.length-2]) + ", Suma min: " + (results[0]+results[1]));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
