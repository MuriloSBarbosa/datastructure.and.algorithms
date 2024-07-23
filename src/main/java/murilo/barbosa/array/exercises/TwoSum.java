package murilo.barbosa.array.exercises;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            var targetIndex = map.get(complement);

            if (targetIndex != null && targetIndex != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        return new int[]{};
    }
}
