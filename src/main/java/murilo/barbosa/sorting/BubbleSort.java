package murilo.barbosa.sorting;

public class BubbleSort {

    public static void bubbleSort(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 1; j < (vetor.length - i); j++) {
                if (vetor[j - 1] > vetor[j]) {
                    int aux = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
    }
}
