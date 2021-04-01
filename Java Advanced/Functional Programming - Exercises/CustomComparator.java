package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        List<Integer> list = Arrays.stream(text.split("\\s+"))
                .map(Integer::parseInt).filter(num -> num % 2 == 0).sorted(Comparator.comparing(num -> num % 2 != 0)).collect(Collectors.toList());

        list = list.stream().sorted((l,r) -> Integer.compare(l,r))
                .collect(Collectors.toList());

        List<Integer> list2 = Arrays.stream(text.split("\\s+"))
                .map(Integer::parseInt)
                .filter(num -> num % 2 != 0)
                .sorted((l,r) -> Integer.compare(l,r))
                .collect(Collectors.toList());

        list.forEach(num -> System.out.print(num + " "));
        list2.forEach(num -> System.out.print(num + " "));
    }
}
