package StackAndQueues;


import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] info = scan.nextLine().split("\\s+");

        int n = Integer.parseInt(scan.nextLine());
        for (String s : info) {
            queue.offer(s);
        }
        int counter = 0;
        while (queue.size() > 1) {

            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            counter++;

            if (isPrime(counter)) {
                System.out.printf("Prime %s%n", queue.peek());
            } else {
                System.out.printf("Removed %s%n", queue.poll());
            }

        }
        System.out.printf("Last is %s", queue.poll());
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
