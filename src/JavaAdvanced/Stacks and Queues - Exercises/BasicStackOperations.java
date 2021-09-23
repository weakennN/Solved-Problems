package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] info = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersToAdd = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = info[0];
        int s = info[1];
        int x = info[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbers.push(numbersToAdd[i]);
        }

        for (int i = 0; i < s; i++) {
            numbers.pop();
        }

        if (numbers.contains(x)) {
            System.out.println("true");
            return;
        } else {

            if (numbers.size() >= 1) {
                System.out.println(minNumber(numbers));
            } else {
                System.out.println(0);
            }
        }

    }

    public static int minNumber(ArrayDeque<Integer> numbers) {
        int min = numbers.pop();

        for (int i = 0; i < numbers.size(); i++) {
            if (min > numbers.peek()) {
                min = numbers.peek();
            }
            numbers.pop();
        }
        return min;
    }

}
