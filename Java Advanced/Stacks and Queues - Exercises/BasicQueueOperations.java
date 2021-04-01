package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int[] info = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersToAdd = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = info[0];
        int s = info[1];
        int x = info[2];

        for (int i = 0; i < n; i++) {
            queue.offer(numbersToAdd[i]);
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(minNumber(queue));
        }

    }

    public static int minNumber(ArrayDeque<Integer> numbers) {
        int min = Integer.MAX_VALUE;

        for (int number : numbers) {

            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}