package SetsAntMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> player1 = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> player2 = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {


            if (player1.isEmpty() || player2.isEmpty()) {
                break;
            }

            int firstNumber = player1.iterator().next();
            player1.remove(firstNumber);
            int secondNumber = player2.iterator().next();
            player2.remove(secondNumber);

            if (firstNumber > secondNumber) {
                player1.add(firstNumber);
                player1.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                player2.add(firstNumber);
                player2.add(secondNumber);
            }

        }

        if (player1.size() < player2.size()) {
            System.out.println("Second player win!");
        } else if (player2.size() < player1.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
