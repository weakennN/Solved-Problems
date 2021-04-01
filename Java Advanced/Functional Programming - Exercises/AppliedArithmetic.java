package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        IntUnaryOperator add = e -> e += 1;
        IntUnaryOperator subtract = e -> e -= 1;
        IntUnaryOperator multiply = e -> e *= 2;

        String command = scan.nextLine();

        while (!command.equals("end")) {

            if (command.equals("add")) {

                numbers = Arrays.stream(numbers)
                        .map(add)
                        .toArray();

            } else if (command.equals("subtract")) {

                numbers = Arrays.stream(numbers)
                        .map(subtract)
                        .toArray();

            }else if(command.equals("multiply")){

                numbers = Arrays.stream(numbers)
                        .map(multiply)
                        .toArray();

            }else if(command.equals("print")){

                String output = Arrays.stream(numbers)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
                System.out.println(output);

            }

            command = scan.nextLine();
        }
    }
}
