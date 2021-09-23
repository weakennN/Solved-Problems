package AssociativeArrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(e -> Double.parseDouble(e))
                .toArray();

        Map<Double, Integer> num = new TreeMap<>();

        for (int i = 0; i < numbers.length; i++) {

            if (num.containsKey(numbers[i])) {
                num.put(numbers[i], num.get(numbers[i]) + 1);
            } else {
                num.put(numbers[i], 1);
            }
        }

        for (Map.Entry<Double, Integer> a : num.entrySet()) {
            System.out.printf("%.0f -> %s%n", a.getKey(), a.getValue());
        }
    }
}
