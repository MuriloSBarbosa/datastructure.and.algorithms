package murilo.barbosa.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 1, 3, 2};
        System.out.println(Arrays.toString(array));
        quickSortMiddleElement(0, array.length - 1, array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {5, 2, 4, 7, 1, 3, 2, 6};

        System.out.println(Arrays.toString(array2));
        quickSortLastElement(0, array2.length - 1, array2);
        System.out.println(Arrays.toString(array2));

    }

    private static void quickSortLastElement(int originalStart, int originalEnd, int[] array) {
        int end = originalEnd;
        int pivot = array[originalEnd];

        for (int i = originalEnd - 1; i >= originalStart; i--) {
            if (array[i] > pivot) {
                end--;
                int aux = array[i];
                array[i] = array[end];
                array[end] = aux;
            }
        }

        int aux = array[originalEnd];
        array[originalEnd] = array[end];
        array[end] = aux;

        if (originalStart < end) {
            quickSortLastElement(originalStart, end - 1, array);
        }

        if (end < originalEnd) {
            quickSortLastElement(end + 1, originalEnd, array);
        }
    }

    private static void quickSortMiddleElement(int originalStart, int originalEnd, int[] array) {

        int start = originalStart;
        int end = originalEnd;
        int pivot = array[(originalEnd + originalStart) / 2];

        while (start <= end) {
            while (start < originalEnd && array[start] < pivot) {
                start++;
            }
            while (end > originalStart && array[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int aux = array[start];
                array[start] = array[end];
                array[end] = aux;
                start++;
                end--;
            }
        }
        if (originalStart < end) {
            quickSortMiddleElement(originalStart, end, array);
        }

        if (start < originalEnd) {
            quickSortMiddleElement(start, originalEnd, array);
        }
    }
}
