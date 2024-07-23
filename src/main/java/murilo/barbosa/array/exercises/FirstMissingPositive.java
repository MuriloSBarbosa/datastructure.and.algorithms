package murilo.barbosa.array.exercises;


import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        firstMissingPositive(new int[]{0, 2, 2, 1, 1});
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        var count = 1;
        var validated = false;
        var isValid = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                isValid = true;
            }
        }

        if (!isValid) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            var current = nums[i];

            if (current <= 0) {
                continue;
            } else {
                if (!validated) {
                    count = current;
                    validated = true;
                } else {
                    if (current == nums[i - 1]) {
                        continue;
                    }
                }
            }

            if (current != count) {
                return count;
            }
            count++;
        }

        return count;
    }
}
