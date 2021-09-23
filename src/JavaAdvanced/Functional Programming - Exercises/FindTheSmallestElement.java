package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>,Integer> findMin = num -> {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int i = 0;i < list.size();i++){

                if (list.get(i) <= min){
                    min = list.get(i);
                    minIndex = i;
                }
            }

            return minIndex;
        };

        System.out.println(findMin.apply(list));
    }
}
