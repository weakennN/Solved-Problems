package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int min = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .min().getAsInt();

        System.out.println(min);



    }
}
