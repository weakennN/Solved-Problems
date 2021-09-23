package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            String command = scan.nextLine();
            String[] info = command.split("\\s+");

            if ("1".equals(info[0])) {
                if (info.length == 2) {
                    int num = Integer.parseInt(info[1]);
                    stack.push(num);
                }
            } else if ("2".equals(info[0])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ("3".equals(info[0])) {
                if (stack.size() >= 1) {
                    int max = stack.peek();
                    for (int j = 0; j < stack.size(); j++) {
                        stack.add(stack.pop());
                        if (stack.peek() > max) {
                            max = stack.peek();
                        }

                    }
                    System.out.println(max);
                }
            }


        }
    }
}
