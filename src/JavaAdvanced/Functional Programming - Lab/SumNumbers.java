package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

            Function<int[],String> getCount = array -> "Count = " + array.length;
            Function<int[],String> getSum = array -> "Sum = " +  Arrays.stream(array)
                    .sum();

        System.out.println(getCount.apply(arr));

        System.out.println(getSum.apply(arr));


    }
}
