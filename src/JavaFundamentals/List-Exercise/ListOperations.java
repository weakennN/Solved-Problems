package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("End")) {

            String[] com = command.split(" ");
            String com1 = com[0];
            switch (com1) {
                case "Add":
                    int n = Integer.parseInt(com[1]);
                    numbers.add(n);
                    break;
                case "Insert":
                    n = Integer.parseInt(com[1]);
                    int index = Integer.parseInt(com[2]);
                    if (isValid(index, numbers)) {
                        numbers.add(index, n);
                    } else {
                        System.out.print("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(com[1]);

                    if (isValid(index, numbers)) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int counter = Integer.parseInt(com[2]);
                    if (com[1].equals("left")) {

                    /*    for (int i = 0; i < counter; i++) {
                            int temp = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(temp);
                        }
                     */
                        for (int i = 0; i < counter; i++) {

                            for (int j = 0; j < numbers.size() - 1; j++) {
                                int temp = numbers.get(j + 1);
                                numbers.set(j + 1, numbers.get(j));
                                numbers.set(j, temp);
                            }
                        }
                    } else if (com[1].equals("right")) {

                       /*
                        for (int i = 0; i < counter; i++) {
                            int temp = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0, temp);
                        }
                    }
                  */
                        for (int i = 0; i < counter; i++) {
                            for (int j = 0; j < numbers.size() - 1; j++) {
                                int temp = numbers.get(numbers.size() - j - 2);
                                numbers.set(numbers.size() - j - 2, numbers.get(numbers.size() - j - 1));
                                numbers.set(numbers.size() - j - 1, temp);
                            }
                        }
                        break;
                    }

            }
            command = scan.nextLine();
        }
        for (Integer parts : numbers) {
            System.out.print(parts + " ");
        }

    }

    public static boolean isValid(int index, List<Integer> numbers) {
        return (index >= 0 && index < numbers.size());
    }
}
