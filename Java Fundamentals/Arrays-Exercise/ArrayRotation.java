package ArraysLab;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

 /*       for(int i = 0;i < n;i++){
            String temp = array[0];
            for(int j = 0;j < array.length - 1;j++){
                array[j] = array[j + 1];
            }
            array[array.length - 1] = temp;
        }
       System.out.println(String.join(" ",array));
     */
        for (int i = 0; i < n; i++) {
            String temp1 = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp1;
        }
        System.out.println(String.join(" ", array));
    }
}
