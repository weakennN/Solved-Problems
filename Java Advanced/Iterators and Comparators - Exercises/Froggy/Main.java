package IteratorsAndComparators.Froggy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("[, ]+");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        StringBuilder str = new StringBuilder();
        Lake lake = new Lake(arr);
        for (Integer item : lake) {

            str.append(item + ", ");
        }

        System.out.println(str.toString().substring(0,str.lastIndexOf(", ")));
    }
}
