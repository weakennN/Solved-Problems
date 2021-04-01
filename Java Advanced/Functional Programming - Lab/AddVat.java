package FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> addVat = num -> num * 1.20;

        System.out.println("Prices with VAT:");

        Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(addVat::apply)
                .forEach(num -> System.out.printf("%.2f%n",num));

    }
}
