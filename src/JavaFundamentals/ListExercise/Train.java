package JavaFundamentals.ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int max = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        while (!command.equals("end")) {

            String[] com = command.split(" ");

            if (com[0].equals("Add")) {
                int n = Integer.parseInt(com[1]);
                numbers.add(n);

            } else {
                int m = Integer.parseInt(com[0]);

                for (int i = 0; i < numbers.size(); i++) {

                    if ((numbers.get(i) + m) <= max) {

                        numbers.set(i, numbers.get(i) + m);
                        break;
                    }
                }
            }
            command = scan.nextLine();
        }

        for (int parts : numbers) {
            System.out.print(parts + " ");
        }
    }
}
