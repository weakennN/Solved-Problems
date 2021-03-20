package MethodsLab;

import java.util.Scanner;

public class CharInRange {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char first = scan.nextLine().charAt(0);
        char second = scan.nextLine().charAt(0);

        printInRange(Math.min(first, second), Math.max(second, first));
    }

    public static void printInRange(int start, int end) {
       /* int a = Math.min(start, end);
        int b = Math.max(start, end);
        for (++a; a < b; a++) {
            System.out.print((char) a + " ");
        }

        */
        for (int i = ++start; i < end; i++) {
            System.out.print((char) i + " ");
        }
    }
}
