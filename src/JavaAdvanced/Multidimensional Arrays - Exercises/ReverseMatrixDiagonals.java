package MultidimensionalArrays;

import java.util.Scanner;

public class ReverseMatrixDiagonals {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = readMatrix(scan);


        for (int col = 0; col < matrix[0].length; col++) {

            printBottodD(matrix.length - 1, matrix, matrix[0].length - 1 - col);
            System.out.println();
        }

        printTheRestD(matrix, matrix.length - 2);

    }

    public static void printTheRestD(int[][] matrix, int row) {

        for (; row >= 0; row--) {

            for (int col = 0, row1 = row; row1 >= 0 && col < matrix[0].length; row1--, col++) {
                System.out.print(matrix[row1][col] + " ");
            }
            System.out.println();
        }
    }

    public static void printBottodD(int row, int[][] matrix, int col) {

        for (int cols = col; cols < matrix[0].length && row >= 0; cols++, row--) {

            System.out.print(matrix[row][cols] + " ");
        }
    }

    public static int[][] readMatrix(Scanner scan) {

        String[] input = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] info = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(info[col]);

            }
        }

        return matrix;
    }

}