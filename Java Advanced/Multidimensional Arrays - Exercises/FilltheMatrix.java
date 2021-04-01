package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilltheMatrix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        String pattern = input[1];

        if (pattern.equals("A")) {
            int[][] matrixA = PatternA(rows);
            printMatrix(matrixA);
        } else if (pattern.equals("B")) {
            int[][] matrixB = patternB(rows);
            printMatrix(matrixB);
        }
    }

    public static int[][] PatternA(int rows) {

        int[][] matrix = new int[rows][rows];

        for (int col = 0; col < matrix.length; col++) {

            for (int row = 0; row < matrix.length; row++) {

                matrix[row][col] = (col * matrix.length) + row + 1;
            }
        }

        return matrix;
    }

    public static int[][] patternB(int rows) {

        int[][] matrix = new int[rows][rows];

        matrix[0][0] = 1;

        for (int i = 1; i < rows; i++) {

            if (i % 2 != 0) {

                matrix[0][i] = (i + 1) * matrix.length;
            } else {
                matrix[0][i] = matrix[0][i - 1] + 1;

            }
        }

        for (int col = 0; col < matrix.length; col++) {

            for (int row = 1; row < matrix.length; row++) {
                if (col % 2 != 0) {
                    matrix[row][col] = matrix[row - 1][col] - 1;
                } else {
                    matrix[row][col] = matrix[row - 1][col] + 1;
                }
            }
        }

        return matrix;
    }


    public static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
