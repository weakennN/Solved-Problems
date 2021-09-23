package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        if (str.length() % 2 != 0) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' && stack.pop() != '(') {
                System.out.println("NO");
                return;
            } else if (str.charAt(i) == ']' && stack.pop() != '[') {
                System.out.println("NO");
                return;
            } else if (str.charAt(i) == '}' && stack.pop() != '{') {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

}
