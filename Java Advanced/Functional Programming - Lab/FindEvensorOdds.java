package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensorOdds {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        String condition = scan.nextLine();

        Predicate<Integer> predicate = evenOrOdd(condition);

        IntStream.range(start, end + 1).boxed().filter(predicate)
                .forEach(e -> System.out.print(e + " "));

    }

    public static Predicate<Integer> evenOrOdd(String condition) {

        if (condition.equals("odd")) {
            return num -> num % 2 != 0;
        }
        return num -> num % 2 == 0;
    }
}
