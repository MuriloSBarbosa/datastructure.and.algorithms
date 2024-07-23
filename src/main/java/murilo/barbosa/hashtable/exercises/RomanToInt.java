package murilo.barbosa.hashtable.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        // 194
        romanToInt("III");
    }

    public static int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            sum.add(map.get(s.charAt(i)));
        }
        for (int i = 0; i < sum.size(); i++) {
            var atual = sum.get(i);

            var next = 0;
            if (i + 1 < sum.size()) {
                next = sum.get(i + 1);
            }
            if (next > atual) {
                result += next - atual;
                i++;
            } else {
                result += atual;
            }
        }
        return result;
    }
}
