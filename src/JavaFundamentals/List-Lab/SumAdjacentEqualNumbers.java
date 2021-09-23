package Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers =
                Arrays.stream(scan.nextLine().split(" "))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
        for (int i = 0; i < numbers.size() - 1; i++) {
            double current = numbers.get(i);
            double next = numbers.get(i + 1);
            if (current == next) {
                numbers.remove(i + 1);
                numbers.set(i, current + next);

                i = -1;
            }

        }
        DecimalFormat output = new DecimalFormat("0.#");
        for (Double parts : numbers) {
            System.out.print(output.format(numbers) + " ");
        }


    }
}
