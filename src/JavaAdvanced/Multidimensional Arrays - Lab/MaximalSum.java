package MultidimensionalArrays;

import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        int[][] resultMatrix = findTheBest3x3Matrix(matrix);
        printMatrix(resultMatrix);

    }

    public static int[][] findTheBest3x3Matrix(int[][] matrix) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int[][] matrix3x3 = new int[3][3];

        for (int row = 0; row < matrix.length - 2; row++) {

            for (int col = 0; col < matrix[row].length - 2; col++) {

                sum += matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1]
                        + matrix[row + 1][col + 2] + matrix[row + 2][col]
                        + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;

                    for (int i = 0; i < matrix3x3.length; i++) {

                        for (int j = 0; j < matrix3x3[i].length; j++) {

                            matrix3x3[i][j] = matrix[row + i][col + j];
                        }
                    }
                }
                sum = 0;

            }
        }
        System.out.println("Sum = " + maxSum);
        return matrix3x3;
    }

    public static int[][] readMatrix(Scanner scan) {

        String[] input = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            String[] tokens = scan.nextLine().split("\\s+");
            for (int j = 0; j < tokens.length; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
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
