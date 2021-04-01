package SetsAntMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<Double, Integer> countNumbers = new LinkedHashMap<>();

        String numbers = scan.nextLine();

        String[] info = numbers.split("\\s+");

        for (int i = 0; i < info.length; i++) {

            double n = Double.parseDouble(info[i]);

            if (countNumbers.containsKey(n)) {
                countNumbers.put(n, countNumbers.get(n) + 1);
            } else {
                countNumbers.put(n, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : countNumbers.entrySet()) {

            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
