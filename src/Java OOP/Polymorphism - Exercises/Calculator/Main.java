package Polymorphism.Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        InputInterpreter interpreter = new InputInterpreter();

        String line = scan.nextLine();
        while (true) {

            int result = interpreter.interpretLine(line);
            System.out.println(result);

            if (line.contains("end")) {
                break;
            }

            line = scan.nextLine();
        }
    }
}
