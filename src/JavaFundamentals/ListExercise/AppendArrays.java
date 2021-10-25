package JavaFundamentals.ListExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");

        List<Integer> numbers = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {

            String[] temp = input[i].split("\\s+");

            for (String parts : temp) {
                if (!parts.equals("")) {
                    int n = Integer.parseInt(parts);
                    numbers.add(n);
                }

            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }

    }
}

