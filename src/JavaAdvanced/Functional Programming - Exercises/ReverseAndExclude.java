package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> array = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(array);

        int number = Integer.parseInt(scan.nextLine());

        Predicate<Integer> removeIfEquals = num -> num % number != 0;

       array.stream().filter(removeIfEquals)
               .forEach(num -> System.out.print(num + " "));
    }
}
