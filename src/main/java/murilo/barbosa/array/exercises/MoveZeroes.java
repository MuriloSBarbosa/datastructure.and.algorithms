package murilo.barbosa.array.exercises;

public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0});

    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pointer > nums.length - 1) {
                break;
            }

            int current = nums[pointer];
            while (current == 0) {
                count++;
                pointer++;
                if (pointer > nums.length - 1) {
                    break;
                }
                current = nums[pointer];
            }
            nums[i] = current;
            pointer++;
        }

        for (int i = nums.length - 1; i > nums.length - count - 1; i--) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int count = 0;
        for (int current : nums) {
            if (current == 0) {
                count++;
            }
        }
        int pointer = 0;
        for (int i = 0; i < nums.length - count; i++) {
            int current = nums[pointer];
            while (current == 0) {
                current = nums[++pointer];
            }
            nums[i] = current;
            pointer++;

        }
        for (int i = nums.length - 1; i > nums.length - 1 - count; i--) {
            nums[i] = 0;
        }
    }
}
