package StackAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] storage;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        storage = new long[n + 1];
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {

        if (n <= 1) {
            return 1;
        }

        if (storage[n] != 0) {
            return storage[n];
        }

        return storage[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
