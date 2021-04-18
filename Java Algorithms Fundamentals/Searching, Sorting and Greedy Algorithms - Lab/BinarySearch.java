package SearchingSortingAndGreedyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int key = Integer.parseInt(scan.nextLine());

        int indexToFind = binarySearch(arr, key);

        System.out.println("The index of " + key + " is " + indexToFind);
    }

    public static int binarySearch(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] < key) {

                left = mid + 1;
            } else if (arr[mid] > key) {

                right = mid - 1;
            } else {

                return mid;
            }
        }


        return -1;
    }
}
