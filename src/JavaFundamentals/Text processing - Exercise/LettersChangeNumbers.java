package TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        double finalSum = 0.0;
        for (String word : input) {

            char first = word.charAt(0);
            char second = word.charAt(word.length() - 1);
            String numberStr = word.substring(1, word.length() - 1);

            long number = Integer.parseInt(numberStr);
            double sum = 0;

            if (Character.isUpperCase(first)) {
                sum = number * 1.0 / (first - 64);
            } else {
                sum = number * (first - 96);
            }

            if (Character.isUpperCase(second)) {
                sum -= second - 64;

            } else {
                sum += second - 96;
            }
            finalSum += sum;
        }

        System.out.printf("%.2f", finalSum);
    }
}
