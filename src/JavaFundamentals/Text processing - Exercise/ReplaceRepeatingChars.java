package TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        StringBuilder sb = new StringBuilder();

        char base = input.charAt(0);
        sb.append(base);

        for (int i = 1; i < input.length(); i++) {

            char current = input.charAt(i);

            if (current != base) {
                sb.append(current);
                base = current;
            }
        }

        System.out.println(sb);
    }
}
