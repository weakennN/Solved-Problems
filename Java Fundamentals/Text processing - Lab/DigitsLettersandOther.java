package TextProcessing;

import java.util.Scanner;

public class DigitsLettersandOther {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char add = input.charAt(i);
            if (Character.isDigit(add)) {
                digits.append(add);
            } else if (Character.isAlphabetic(add)) {
                letters.append(add);
            } else {
                others.append(add);
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}
