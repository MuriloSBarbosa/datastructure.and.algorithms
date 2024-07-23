package murilo.barbosa.array.exercises;

import java.util.Arrays;
import java.util.Collections;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("Hello World!"));
        System.out.println(reverse2("Hello World!"));
    }

    public static String reverse(String str) {
        var result = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static String reverse2(String str) {
        var result = Arrays.asList(str.split(""));
        Collections.reverse(result);
        return String.join("", result);
    }
}
