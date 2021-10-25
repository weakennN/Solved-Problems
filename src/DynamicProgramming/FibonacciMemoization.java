package DynamicProgramming;

public class FibonacciMemoization {

    private static int[] memoization = new int[31];

    public static void main(String[] args) {
        System.out.println(fib(30));
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (memoization[n] != 0) {
            return memoization[n];
        }

        return memoization[n] = fib(n - 1) + fib(n - 2);
    }
}
