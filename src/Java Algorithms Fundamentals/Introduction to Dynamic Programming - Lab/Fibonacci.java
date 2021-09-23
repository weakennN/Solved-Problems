package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    public static long[] memo;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        memo = new long[n + 1];
        Arrays.fill(memo,-1);

        System.out.println(fib(n));
    }

    public static long fib(int n) {

        if (n <= 2) {

            return 1;
        }else if(memo[n] != -1){

            return memo[n];
        }

        return memo[n] = fib(n - 1) + fib(n - 2);
    }
}
