package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class NumersInReversOrder {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int [] numbers = new int[n];
        for(int i = 0;i < numbers.length;i++){
            numbers[i] = Integer.parseInt(scan.nextLine());
        }
        for(int i = numbers.length - 1;i >= 0;i--){
            System.out.print(numbers[i] + " ");
        }
    }
}
