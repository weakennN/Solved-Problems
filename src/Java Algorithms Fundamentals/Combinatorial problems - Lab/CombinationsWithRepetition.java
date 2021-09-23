package CombinatorialProblems;

import java.util.Scanner;

public class CombinationsWithRepetition {

    public static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int k = Integer.parseInt(scan.nextLine());
        arr = new int[k];
        comb(0,0,n);

    }

    public static void comb(int index, int start, int n) {

        if (index >= arr.length) {

            print();
            return;
        }

        for (int i = start; i < n; i++) {

            arr[index] = i + 1;
            comb(index + 1, i, n);
        }
    }

    public static void print() {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
