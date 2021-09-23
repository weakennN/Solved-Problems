package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Predicate<Integer> isEven = num -> num % 2 == 0;

        List<Integer> list = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String output = list.stream()
                .filter(isEven)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(output);

        System.out.println(output = list.stream()
                .filter(isEven)
                .sorted(Integer::compare)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));


    }
}
