package murilo.barbosa.array.exercises;

public class FirstAndLastPositionOfElement {

    public static void main(String[] args) {
        searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3);
    }

    public static int[] searchRange(int[] nums, int target) {
        var start = binarySearch(nums, target, true);
        var end = binarySearch(nums, target, false);

        System.out.println("[" + start + ", " + end + "]");

        return new int[]{start, end};
    }

    public static int binarySearch(int[] nums, int target, boolean findFirst) {
        var start = 0;
        var end = nums.length - 1;

        while (start <= end) {
            var middle = (start + end) / 2;
            var current = nums[middle];

            if (current == target) {
                if (findFirst) {
                    var before = middle - 1;
                    if (before >= 0 && nums[before] == target) {
                        start--;
                    } else {
                        return middle;
                    }
                } else {
                    var next = middle + 1;
                    if (next < nums.length && nums[next] == target) {
                        start++;
                    } else {
                        return middle;
                    }
                }
            } else if (target > current) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
