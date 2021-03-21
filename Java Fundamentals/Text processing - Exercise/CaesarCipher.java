package TextProcessing;

import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String result = "";
        for (int i = 0; i < input.length(); i++) {

            int a = input.charAt((i)) + 3;
            result += (char) a;
        }

        System.out.println(result);
    }
}
