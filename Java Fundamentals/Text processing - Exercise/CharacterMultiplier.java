package TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        int min = Math.min(input[0].length(), input[1].length());
        int max = Math.max(input[0].length(), input[1].length());
        int i = 0;
        long sum = 0;

        for (i = 0; i < min; i++) {
            sum += input[0].charAt(i) * input[1].charAt(i);
        }

        for (; i < max; i++) {

            if (input[0].length() > min) {
                sum += input[0].charAt(i);
            } else {
                sum += input[1].charAt(i);
            }
        }

        System.out.println(sum);
    }
}
