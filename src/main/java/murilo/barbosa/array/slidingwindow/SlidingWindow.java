package murilo.barbosa.array.slidingwindow;

public class SlidingWindow {

    public static void main(String[] args) {
        maxSubArraySum(new int[]{1, 2, 3, 1, 2, 1, 1, 1, 5}, 3);
    }

     // nums = [1,2,3,1,2,1,1,1,5], k = 3

    public static int maxSubArraySum(int[] nums, int slider) {
        int max = Integer.MIN_VALUE; // 6
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // 3

            // 6
            sum += nums[i];

            if (i >= slider) {
                sum -= nums[i - slider];
            }

            if (i >= slider - 1) {
                max = Math.max(max, sum);
            }

        }
        return max;
    }
}
