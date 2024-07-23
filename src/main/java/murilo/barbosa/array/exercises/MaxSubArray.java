package murilo.barbosa.array.exercises;


public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int current : nums) {
            if (current > count + current) {
                count = current;
            } else {
                count += current;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
