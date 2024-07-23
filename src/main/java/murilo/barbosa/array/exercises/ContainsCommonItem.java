package murilo.barbosa.array.exercises;

import java.util.HashSet;

public class ContainsCommonItem {


    public boolean containsCommonItem(int[] arr1, int[] arr2) {
        var map = new HashSet<>();

        for (int number : arr1) {
            map.add(number);
        }

        for (int number : arr2) {
            if (map.contains(number)) {
                return true;
            }
        }

        return false;
    /*
     * Time complexity: O(n)
     * Space complexity: 0(1)
     */
    }
}
