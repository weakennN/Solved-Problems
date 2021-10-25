package RecursionAndBacktracking;

import java.util.Scanner;

public class Generating0And1Vectors {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] arr = new int[n];
        printVectors(arr, arr.length - 1);
    }

    public static void printVectors(int[] arr, int index) {

        if (index < 0) {

            print(arr);
            return;
        }

        for (int i = 0; i < 2; i++) {
            arr[index] = i;
            printVectors(arr, index - 1);
        }

    }

    public static void print(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            System.out.print(arr[i]);
        }

        System.out.println();
    }
}
