package CombinatorialProblems;

import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetitions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split("\\s+");
        permute(0, arr);
    }

    public static void permute(int index, String[] arr) {

        if (index >= arr.length) {

            print(arr);
            return;
        }

        permute(index + 1, arr);
        HashSet<String> swapped = new HashSet<>();
        swapped.add(arr[index]);

        for (int i = index + 1; i < arr.length; i++) {

            if (!swapped.contains(arr[i])) {
                swap(i, index, arr);
                permute(index + 1, arr);
                swap(i, index, arr);
                swapped.add(arr[i]);
            }
        }
    }

    public static void print(String[] arr) {

        System.out.println(String.join(" ", arr));
    }

    public static void swap(int i, int j, String[] arr) {

        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
