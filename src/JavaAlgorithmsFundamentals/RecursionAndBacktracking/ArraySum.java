package RecursionAndBacktracking;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = gerArraySum(arr, arr.length - 1);
        System.out.println(sum);
    }

    public static int gerArraySum(int[] arr, int n) {

        if (n == 0) {

            return arr[n];
        }

        return arr[n] + gerArraySum(arr, n - 1);
    }
}
