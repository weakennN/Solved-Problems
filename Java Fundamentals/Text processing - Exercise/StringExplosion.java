package TextProcessing;


import java.util.Scanner;

public class StringExplosion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String com = scan.nextLine();
        StringBuilder input = new StringBuilder();
        int power = 0;

        for (int i = 0; i < com.length(); i++) {

            String current = "" + com.charAt(i);
            if (current.equals(">")) {
                String numbersStr = "" + com.charAt(i + 1);
                power += Integer.parseInt(numbersStr);
                input.append(current);
            } else if (power == 0) {
                input.append(current);
            } else {
                power--;
            }
        }
        System.out.println(input);

    }
}

