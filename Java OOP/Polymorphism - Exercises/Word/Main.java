package Polymorphism.Word;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        TextTransform textTransform = new TextTransform(text);

        textTransform.uppercase(0, 0);

        String command = scan.nextLine();

        while (!command.equals("exit")) {

            String[] token = command.split("\\s+");

            String com = token[0];
            int startIndex = Integer.parseInt(token[1]);
            int endIndex = Integer.parseInt(token[2]);
            
            if (com.equals("cut")) {

                textTransform.cut(startIndex, endIndex);
            } else if (com.equals("uppercase")) {

                textTransform.uppercase(startIndex, endIndex);
            } else if (com.equals("paste")) {

                textTransform.paste(startIndex, endIndex);
            }


            command = scan.nextLine();
        }

        System.out.println(textTransform.getText());

    }
}
