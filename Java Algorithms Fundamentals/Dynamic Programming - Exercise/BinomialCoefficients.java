package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BinomialCoefficients {

    public static long[][] memo;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int k = Integer.parseInt(scan.nextLine());

        memo = new long[n + 1][k + 1];

        System.out.println(binomial(n, k));
    }

    public static long binomial(int n, int k) {

        if (k > n) {

            return 0;
        } else if (k == 0 || n <= 1) {

            return 1;
        } else if (memo[n][k] != 0) {

            return memo[n][k];
        }

        return memo[n][k] = binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
}
