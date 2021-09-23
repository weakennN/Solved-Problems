package Generics.Tuple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            String[] input = scan.nextLine().split("\\s+");
            Tuple<String> tuple;

            if (input.length == 3) {
                tuple = new Tuple<>(input[0] + " " + input[1], input[2]);
            } else {
                tuple = new Tuple<>(input[0], input[1]);
            }

            System.out.println(tuple.toString());
        }
    }
}
