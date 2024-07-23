package murilo.barbosa.hashtable.exercises;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    public static void main(String[] args) {
        intToRoman(1994);
    }

    public static String intToRoman(int num) {
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        int qtd = num / 1000;
        for (int k = 0; k < qtd; k++) {
            result += map.get(1000);
        }
        int resto = num % 1000;

        for (int i = 100; i >= 1; i = i / 10) {
            qtd = resto / i;
            resto = resto % i;

            if (qtd < 4) {
                for (int k = 0; k < qtd; k++) {
                    result += map.get(i);
                }
            } else if (qtd == 4) {
                result += map.get(i) + map.get(i * 5);
            } else if (qtd < 9) {
                result += map.get(i * 5);
                for (int k = 0; k < qtd - 5; k++) {
                    result += map.get(i);
                }
            } else {
                result += map.get(i) + map.get(i * 10);
            }
        }
        return result;
    }

    public static String intToRoman2(int num) {
        String result = "";

        // 3749
        int qtd = num / 1000;
        for (int i = 0; i < qtd; i++) {
            result += "M";
        }

        // 749
        int resto = num % 1000;
        qtd = resto / 100;

        if (qtd < 4) {
            for (int i = 0; i < qtd; i++) {
                result += "C";
            }
        } else if (qtd == 4) {
            result += "CD";
        } else if (qtd < 9) {
            result += "D";
            for (int i = 0; i < qtd - 5; i++) {
                result += "C";
            }
        } else {
            result += "CM";
        }

        // 49
        resto = resto % 100;
        qtd = resto / 10;
        if (qtd < 4) {
            for (int i = 0; i < qtd; i++) {
                result += "X";
            }
        } else if (qtd == 4) {
            result += "XL";
        } else if (qtd < 9) {
            result += "L";
            for (int i = 0; i < qtd - 5; i++) {
                result += "X";
            }
        } else {
            result += "XC";
        }

        // 9
        qtd = resto % 10;
        if (qtd < 4) {
            for (int i = 0; i < qtd; i++) {
                result += "I";
            }
        } else if (qtd == 4) {
            result += "IV";
        } else if (qtd < 9) {
            result += "V";
            for (int i = 0; i < qtd - 5; i++) {
                result += "I";
            }
        } else {
            result += "IX";
        }

        return result;
    }
}
