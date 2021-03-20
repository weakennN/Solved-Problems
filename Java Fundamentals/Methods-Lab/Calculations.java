package MethodsLab;

import java.util.Scanner;

public class Calculations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        if (com.equals("add")) {
            add(num1, num2);
        } else if (com.equals("multiply")) {
            multiply(num1, num2);
        } else if (com.equals("subtract")) {
            subtract(num1, num2);
        } else if (com.equals("divide")) {
            divide(num1, num2);
        }
    }

    public static void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    public static void multiply(int num, int num2) {
        System.out.println(num * num2);
    }

    public static void subtract(int num, int num2) {
        System.out.println(num - num2);
    }

    public static void divide(int a, int b) {
        System.out.printf("%.0f", (double) a / b);
    }


}
