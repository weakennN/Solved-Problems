package JavaAlgorithmsFundamentals.RecursionAndCombinatorialProblemsExercise;

import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split("\\s+");

        reverseArray(0, arr.length - 1, arr);
        System.out.println(String.join(" ", arr));
    }

    public static void reverseArray(int first, int second, String[] arr) {

        if (first >= arr.length / 2) {

            return;
        }

        swap(first, second, arr);

        first++;
        second--;

        reverseArray(first, second, arr);
    }

    public static void swap(int i, int j, String[] arr) {

        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
