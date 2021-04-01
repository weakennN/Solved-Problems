package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = readMatrix(scan);
        int firstSum = firstDiagonalSum(matrix);
        int secondSum = secondDiagonalSum(matrix);
        System.out.println(Math.abs(firstSum - secondSum));

    }

    public static int firstDiagonalSum(int[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {

            sum += matrix[i][i];
        }

        return sum;
    }

    public static int secondDiagonalSum(int[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {

            sum += matrix[i][matrix.length - 1 - i];
        }

        return sum;
    }

    public static int[][] readMatrix(Scanner scan) {

        String[] input = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);

        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {

            String[] tokens = scan.nextLine().split("\\s+");
            for (int j = 0; j < tokens.length; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        return matrix;
    }

}
