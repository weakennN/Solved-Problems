package ArraysLab;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         int n = Integer.parseInt(scan.nextLine());
         String [] first = new String[n];
         String [] second = new String[n];

         for(int i = 0;i < first.length;i++){
            String [] idk = scan.nextLine().split(" ");
             if(i % 2 == 0){
                 first[i] = idk[0];
                 second[i] = idk[1];
             }else{
                 first[i] = idk[1];
                 second[i] = idk[0];
             }
         }
        System.out.println(String.join(" ",first));
        System.out.println(String.join(" ",second));



    }
}
