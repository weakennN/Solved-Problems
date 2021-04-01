package Generics.GenericBoxOfInteger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            String clazz = Integer.class + "";
            int a = clazz.indexOf('j');
            String classToString = clazz.substring(a);
            System.out.println(classToString + ": " + number);
        }
    }
}
