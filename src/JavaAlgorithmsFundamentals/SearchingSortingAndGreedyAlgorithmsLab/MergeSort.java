package JavaAlgorithmsFundamentals.SearchingSortingAndGreedyAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sort(arr);

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]).append(" ");
        }

        System.out.println(str);
    }

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int begin, int end) {

        if (begin >= end) {

            return;
        }

        int mid = (begin + end) / 2;

        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    public static void merge(int[] arr, int begin, int mid, int end) {

        if (mid < 0 || mid >= arr.length || arr[mid] < arr[mid + 1]) {
            return;
        }

        int left = begin;
        int right = mid + 1;

        int[] helper = new int[arr.length];

        for (int i = begin; i <= end; i++) {
            helper[i] = arr[i];
        }

        for (int i = begin; i <= end; i++) {
            if (left > mid) {

                arr[i] = helper[right++];
            } else if (right > end) {

                arr[i] = helper[left++];
            } else if (helper[right] < helper[left]) {

                arr[i] = helper[right++];
            } else {

                arr[i] = helper[left++];
            }
        }
    }
}
