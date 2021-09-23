package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);

        int length = Integer.parseInt(scan.nextLine());

        Predicate<String> predicate = num -> num.length() <= length;

        Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(predicate)
                .forEach(System.out::println);
    }
}
