package MethodsLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(repeatString(com,n));

    }
    public static String repeatString(String com,int n){

        String result = "";
      for(int i =0;i < n;i++){
            result += com;
        }
        return result;
    }

}
