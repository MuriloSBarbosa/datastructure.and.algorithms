package murilo.barbosa.array.exercises;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSortedArrays {

    public static void main(String[] args) {
        var result = mergeSortedArrays2(new int[]{1, 4, 5, 7}, new int[]{2, 6, 9, 10});
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        return Stream.of(arr1, arr2).flatMapToInt(Arrays::stream).sorted().toArray();
    }

    public static int[] mergeSortedArrays2(int[] arr1, int[] arr2) {
        var result = new int[arr1.length + arr2.length];
        var i = 0;
        var j = 0;
        var count = 0;

        while(i < arr1.length || j < arr2.length) {
            if(i < arr1.length && arr1[i] < arr2[j]) {
                result[count++] = arr1[i++];
            } else {
                result[count++] = arr2[j++];
            }
        }

        return result;
    }

}
