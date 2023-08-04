package easy;

public class Fibonacci {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getFibonnacciDynamic(50);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        fib(51);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static int getFibonnacciDynamic(int x) {
        int[] arr = new int[x + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= x; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[x];
    }
}
