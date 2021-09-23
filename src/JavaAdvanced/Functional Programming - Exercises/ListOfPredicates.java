package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int range = Integer.parseInt(scan.nextLine());

        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        IntPredicate predicate = num -> {

            for (int i = 0; i < list.size(); i++) {
                if (num % list.get(i) != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.range(1, range + 1).filter(predicate)
                .forEach(num -> System.out.print(num + " "));

    }
}
