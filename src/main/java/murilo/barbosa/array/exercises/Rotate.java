package murilo.barbosa.array.exercises;

import java.util.Arrays;
import java.util.Collections;

public class Rotate {

    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[(i + k) % nums.length] = nums[i];
        }
        Collections.reverse(Arrays.asList(nums));
    }
}
