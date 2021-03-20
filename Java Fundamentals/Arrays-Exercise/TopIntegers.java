package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] <= array[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println(array[array.length - 1]);
    }
}
