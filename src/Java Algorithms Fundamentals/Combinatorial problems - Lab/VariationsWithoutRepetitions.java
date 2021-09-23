package CombinatorialProblems;

import java.util.Scanner;

public class VariationsWithoutRepetitions {

    public static String[] variations;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int k = Integer.parseInt(scan.nextLine());
        variations = new String[k];
        variations(0, input, k);
    }

    public static void variations(int index, String[] input, int k) {

        if (index >= variations.length) {

            print();
            return;
        }

        for (int i = index; i < input.length; i++) {

            variations[index] = input[i];
            variations(index + 1, input, k);

        }
    }

    public static void print() {

        System.out.println(String.join(" ", variations));
    }

    public static void swap(int i, int j, String[] input) {

        String temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
