package murilo.barbosa.extras;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    private static int fibonacciIterative(int n) {
        if (n == 0) {
            return 0;
        }
        int current = 1;
        int prev = 0;
        for (int i = 0; i < n - 1; i++) {
            int aux = current;
            current = current + prev;
            prev = aux;
        }

        return current;
    }

    private static int fibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        return fibonacci(n - 1) - fibonacci(n - 2);
    }
}
