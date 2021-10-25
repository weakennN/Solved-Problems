package JavaFundamentals.ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArraytoNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        while (numbers.length > 1) {
            int[] condense = new int[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                condense[i] = numbers[i] + numbers[i + 1];
            }
            numbers = condense;
        }
        System.out.println(numbers[0]);
    }
}
