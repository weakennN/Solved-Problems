package MethodsLab;

import java.util.Scanner;

public class MultiplyEvensbyOdds {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int digit = 0;
        int evenSum = 0;
        int oddSum = 0;
        while (n != 0) {

            digit = n % 10;
            n /= 10;

            if (digit % 2 == 0) {
                evenSum = evenSum(digit, evenSum);
            } else {
                oddSum = oddSum(digit, oddSum);
            }
        }

        System.out.println(evenSum * oddSum);

    }

    public static int evenSum(int digit, int evenSum) {

        return evenSum += digit;
    }

    public static int oddSum(int digit, int oddSum) {

        return oddSum += digit;
    }
}
