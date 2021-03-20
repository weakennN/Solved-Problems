package MethodsLab;

import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double n = Double.parseDouble(scan.nextLine());

        checkGrade(n);
    }

    public static void checkGrade (double grade){

        if(grade <= 2.99){
            System.out.println("Fail");
        }else if (grade <= 3.49){
            System.out.println("Poor");
        }else if (grade <= 4.49){
            System.out.println("Good");
        }else if(grade <= 5.49){
            System.out.println("Very good");
        }else {
            System.out.println("Excellent");
        }
    }
}
