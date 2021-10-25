package JavaAlgorithmsFundamentals.CombinatorialProblemsLab;

import java.util.Scanner;

public class PermutationsWithoutRepetitions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        permute(0, input);
    }

    public static void permute(int index, String[] input) {

        if (index >= input.length) {

            print(input);
            return;
        }

        for (int i = index; i < input.length; i++) {

            swap(i, index, input);
            permute(index + 1, input);
            swap(i, index, input);
        }

    }

    public static void print(String[] input) {

        System.out.println(String.join(" ", input));
    }

    public static void swap(int i, int j, String[] input) {

        String temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
