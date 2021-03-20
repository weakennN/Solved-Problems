package Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] com = command.split(" ");
            int n = Integer.parseInt(com[1]);
            switch (com[0]) {

                case "Add":
                    numbers.add(n);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(n));
                    break;
                case "RemoveAt":
                    numbers.remove(n);
                    break;
                case "Insert":
                    int index = Integer.parseInt(com[2]);
                    numbers.add(index, n);
                    break;
            }


            command = scan.nextLine();
        }
        for (int parts : numbers) {
            System.out.print(parts + " ");
        }
    }
}
