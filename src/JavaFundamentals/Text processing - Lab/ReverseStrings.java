package TextProcessing;

import java.util.Scanner;

public class ReverseStrings {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();

        while (!word.equals("end")) {

            System.out.print(word + " = ");

            for (int i = word.length() - 1; i >= 0; i--) {
                System.out.print(word.charAt(i));
            }
            System.out.println();

            word = scan.nextLine();
        }
    }
}
