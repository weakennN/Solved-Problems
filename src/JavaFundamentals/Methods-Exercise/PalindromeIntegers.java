package MethodsLab;

import java.util.Scanner;

public class PalindromeIntegers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numbers = scan.nextLine();
        while (!numbers.equals("END")) {
            if (isPalindrome(numbers)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            numbers = scan.nextLine();
        }

    }

    public static boolean isPalindrome(String numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length() / 2; i++) {

            if (numbers.charAt(i) == numbers.charAt(numbers.length() - i - 1)) {
                counter++;
            }
        }
        return (counter == numbers.length() / 2);
    }
}
