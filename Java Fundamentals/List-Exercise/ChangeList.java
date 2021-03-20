package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {

            String[] com = command.split("\\s+");
            Integer n = Integer.valueOf(com[1]);
            if (com[0].equals("Delete")) {

                while (numbers.contains(n)) {
                    numbers.remove(n);
                }
            } else if (com[0].equals("Insert")) {

                int index = Integer.parseInt(com[2]);
                if (index >= 0 && index < numbers.size()) {
                    numbers.add(index, n);
                }
            }

            command = scan.nextLine();
        }
        for (int parts : numbers) {
            System.out.print(parts + " ");
        }
    }
}
