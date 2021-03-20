package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();


        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            int rightSum = 0;
            for (int k = i + 1; k < nums.length; k++) {

                rightSum += nums[k];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }


        }
        System.out.println("no");
    }

}
