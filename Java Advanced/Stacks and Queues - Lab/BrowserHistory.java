package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String current = "";

        while (!command.equals("Home")) {

            if (command.equals("back")) {

                if (stack.size() <= 1) {
                    current = "no previous URLs";

                } else {
                    queue.addFirst(stack.pop());
                    current = stack.peek();
                }

            } else if (command.equals("forward")) {

                if (queue.isEmpty()) {
                    current = "no next URLs";

                } else {
                    current = queue.poll();
                }

            } else {
                stack.push(command);
                current = command;
                queue.clear();
            }
            System.out.println(current);

            command = scan.nextLine();
        }
    }
}
