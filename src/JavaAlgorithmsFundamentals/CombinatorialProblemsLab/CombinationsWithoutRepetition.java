package JavaAlgorithmsFundamentals.CombinatorialProblemsLab;

import java.util.Scanner;

public class CombinationsWithoutRepetition {

    public static String[] comb;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split("\\s+");
        int k = Integer.parseInt(scan.nextLine());
        comb = new String[k];
        combination(0, 0, arr);
    }

    public static void combination(int index, int start, String[] arr) {

        if (index >= comb.length) {

            for (int i = 0; i < comb.length; i++) {

                System.out.print(comb[i] + " ");
            }

            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {

            comb[index] = arr[i];
            combination(index + 1, i + 1, arr);
        }
    }


}
