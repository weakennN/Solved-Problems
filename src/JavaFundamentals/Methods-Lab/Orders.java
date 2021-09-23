package MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String order = scan.nextLine();
        double quantity = Integer.parseInt(scan.nextLine());

        if (order.equals("coffee")) {
            coffee(quantity);
        } else if (order.equals("water")) {
            water(quantity);
        } else if (order.equals("coke")) {
            coke(quantity);
        } else if (order.equals("snacks")) {
            snacks(quantity);
        }

    }

    public static void coffee(double quant) {

        System.out.printf("%.2f", 1.50 * quant);

    }

    public static void water(double quant) {

        System.out.printf("%.2f", 1.00 * quant);

    }

    public static void coke(double quant) {

        System.out.printf("%.2f", 1.40 * quant);

    }

    public static void snacks(double quant) {

        System.out.printf("%.2f", 2.00 * quant);

    }
}
