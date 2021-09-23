package MethodsLab;

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String pass = scan.nextLine();

        if (charLimit(pass)) {

        }
    }

    public static boolean charLimit(String pass) {

        if ((pass.length() >= 6 && pass.length() <= 10)) {
            return true;
        }
        System.out.println("Password must be between 6 and 10 characters");
        return false;
    }
}
