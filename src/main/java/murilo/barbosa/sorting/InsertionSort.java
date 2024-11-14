package murilo.barbosa.sorting;

public class InsertionSort {

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int x = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > x) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = x;
        }
    }
}
