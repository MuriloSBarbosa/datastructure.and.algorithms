package murilo.barbosa.utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

    public TxtReader() {
    }

    public static List<String> readLines(String root) {
        List<String> results = new ArrayList<>();

        try (FileReader fileReader = new FileReader(root)) {
            var reader = new BufferedReader(fileReader);

            String st;

            while ((st = reader.readLine()) != null) {
                results.add(st);
            }

        } catch (IOException e) {
            System.out.println();
        }

        return results;
    }

}
