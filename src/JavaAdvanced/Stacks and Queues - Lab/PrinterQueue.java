package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!command.equals("print")) {

            if (command.equals("cancel")) {

                if (queue.size() <= 0) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", queue.poll());
                }
            } else {
                queue.offer(command);
            }

            command = scan.nextLine();
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
