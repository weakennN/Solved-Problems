package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {

            if (expression.charAt(i) == '(') {
                indexes.push(i);
            } else if (expression.charAt(i) == ')') {
                String result = expression.substring(indexes.pop(), i + 1);
                System.out.println(result);
            }
        }
    }
}
