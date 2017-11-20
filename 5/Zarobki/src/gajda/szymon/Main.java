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

            System.out.println((results[results.length-1]+results[results.length-2]) + " " + (results[0]+results[1]));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
