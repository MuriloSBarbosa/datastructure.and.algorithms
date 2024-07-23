package murilo.barbosa.hashtable.exercises;

import java.util.HashMap;

public class FirstRecurring {

    public static void main(String[] args) {
        var firstRecurring = new FirstRecurring();
        var nums = new int[] {2, 5, 1, 2, 3, 5, 1, 2, 4};
        var result = firstRecurring.firstRecurring(nums);
        System.out.println(result);
    }

    // O(n)
    public Integer firstRecurring (int[] nums) {
        var map = new HashMap<Integer,Boolean>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                return num;
            }
            map.put(num, true);
        }

        return null;
    }
}
