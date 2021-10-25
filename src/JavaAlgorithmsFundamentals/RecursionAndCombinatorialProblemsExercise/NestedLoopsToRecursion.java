package JavaAlgorithmsFundamentals.RecursionAndCombinatorialProblemsExercise;

import java.util.Scanner;

public class NestedLoopsToRecursion {

    public static int[] arr;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        arr = new int[n];
        solution(n, 0);
    }

    public static void solution(int n, int index) {

        if (index >= arr.length) {

            print();
            return;
        }

        for (int i = 0; i < n; i++) {

            arr[index] = i + 1;
            solution(n, index + 1);
        }

    }

    public static void print() {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
