package MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double height = Double.parseDouble(scan.nextLine());
        double weight = Double.parseDouble(scan.nextLine());

        double result = getArea(height, weight);
        System.out.printf("%.0f", result);

    }

    public static double getArea(double a, double b) {

        return a * b;
    }
}
