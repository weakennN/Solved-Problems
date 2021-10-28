package JavaFundamentals.ListLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("end")) {
            int sum = 0;
            String[] com = command.split(" ");

            if (command.equals("Print even")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                System.out.println();
            } else if (command.equals("Print odd")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 != 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                System.out.println();
            } else if (command.equals("Get sum")) {
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.println(sum);
            }

            switch (com[0]) {

                case "Contains":
                    int contains = Integer.parseInt(com[1]);
                    if (numbers.contains(contains)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Filter":
                    int filter = Integer.parseInt(com[2]);
                    if (com[1].equals(">=")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) >= filter) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();

                    } else if (com[1].equals(">")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) > filter) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (com[1].equals("<")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) < filter) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (com[1].equals("<=")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) <= filter) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

            }
            command = scan.nextLine();

        }
    }
}
