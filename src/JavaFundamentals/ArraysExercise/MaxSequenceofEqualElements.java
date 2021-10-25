package JavaFundamentals.ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceofEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int count = 1;
        int bestCount = 0;
        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                if (count > bestCount) {
                    index = nums[i];
                    bestCount = count;
                }

            } else {
                count = 1;
            }
        }
        for (int i = 0; i < bestCount; i++) {
            System.out.print(index + " ");
        }
    }
}
