package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class ConsumerPrint {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] array = scan.nextLine().split("\\s+");

        Arrays.stream(array).forEach(System.out::println);

    }
}
