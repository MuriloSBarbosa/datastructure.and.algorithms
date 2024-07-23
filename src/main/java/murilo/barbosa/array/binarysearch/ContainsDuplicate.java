package murilo.barbosa.array.binarysearch;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() != nums.length;
    }
}
