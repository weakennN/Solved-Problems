package TextProcessing;

import java.util.Scanner;

public class RepeatStrings {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();

        String[] info = com.split(" ");
        String result = "";
        for (int i = 0; i < info.length; i++) {

            for (int j = 0; j < info[i].length(); j++) {
                result += info[i];
            }

        }
        System.out.println(result);
    }
}
