package murilo.barbosa.array.exercises;


public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow(2.0, -2147483648));
    }

    public static double myPow(double x, int n) {
        var result = 1.0;
        var times = Math.abs(n);

        for (int i = 0; i < times; i++) {
            result *= x;
        }

        return n > 0 ? result : 1 / result;
    }
}
