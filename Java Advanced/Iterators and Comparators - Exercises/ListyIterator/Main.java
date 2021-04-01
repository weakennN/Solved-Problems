package IteratorsAndComparators.ListyIterator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        String[] input = command.split("\\s+");
        ListyIterator list = new ListyIterator(input);

        while (!command.equals("END")) {

            input = command.split("\\s+");

            String com = input[0];

            if (com.equals("Move")) {
                System.out.println(list.move());
            } else if (com.equals("HasNext")) {
                System.out.println(list.hasNext());
            } else if (com.equals("Print")) {
                System.out.println(list.print());
            } else if (com.equals("PrintAll")) {
                for (String item : list) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }

            command = scan.nextLine();
        }
    }
}
