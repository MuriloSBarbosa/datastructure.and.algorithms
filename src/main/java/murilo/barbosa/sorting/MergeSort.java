package murilo.barbosa.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 7, 1, 3, 2, 6};
        System.out.println(Arrays.toString(array));

        mergeSort(0, array.length, array);

        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int start, int end, int[] array) {
        if (start < end - 1) {
            int middle = (start + end) / 2;
            mergeSort(start, middle, array);
            mergeSort(middle, end, array);
            interleave(start, middle, end, array);
        }
    }

    private static void interleave(int originalStart, int originalMiddle, int originalEnd,
          int[] array) {

        int[] arrayAux = new int[originalEnd - originalStart];
        int start = originalStart;
        int middle = originalMiddle;
        int k = 0;

        while (start < originalMiddle && middle < originalEnd) {
            if (array[start] < array[middle]) {
                arrayAux[k++] = array[start++];
            } else {
                arrayAux[k++] = array[middle++];
            }
        }

        while (start < originalMiddle) {
            arrayAux[k++] = array[start++];
        }

        while (middle < originalEnd) {
            arrayAux[k++] = array[middle++];
        }

        for (int l = originalStart; l < originalEnd; l++) {
            array[l] = arrayAux[l - originalStart];
        }
    }
}
