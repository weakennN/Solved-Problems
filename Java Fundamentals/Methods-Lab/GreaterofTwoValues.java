package MethodsLab;

import java.util.Scanner;

public class GreaterofTwoValues {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();
        String type = scan.nextLine();
        String type1 = scan.nextLine();

        if (com.equals("int")) {

            int number1 = Integer.parseInt(type);
            int number2 = Integer.parseInt(type1);
            System.out.println(greater(number1, number2));

        } else if (com.equals("char")) {

            System.out.println(greater(type.charAt(0), type1.charAt(0)));

        } else {

            System.out.println(greater(type, type1));

        }
    }

    public static int greater(int num1, int num2) {

        return Math.max(num1, num2);
    }

    public static char greater(char char1, char char2) {

        if (char1 > char2) {
            return char1;
        }
        return char2;
    }

    public static String greater(String name, String name1) {

        if (name.compareTo(name1) >= 0) {
            return name;
        } else {
            return name1;
        }
    }
}
