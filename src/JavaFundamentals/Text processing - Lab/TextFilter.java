package TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] banned = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (int i = 0; i < banned.length; i++) {

            List<String> stars = new ArrayList<>();
            for (int j = 0; j < banned[i].length(); j++) {
                stars.add("*");
            }

            String star = String.join("", stars);
            text = text.replace(banned[i], star);
        }
        System.out.println(text);

    }
}
