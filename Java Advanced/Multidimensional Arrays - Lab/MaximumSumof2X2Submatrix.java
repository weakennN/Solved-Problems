package MultidimensionalArrays;

import java.util.Scanner;

public class MaximumSumof2X2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = readMatrix(scan);
        int max = Integer.MIN_VALUE;
        int[][] resultMatrix = new int[2][2];
        for (int rows = 0; rows < matrix.length - 1; rows++) {

            for (int cols = 0; cols < matrix[rows].length - 1; cols++) {

                int currentNumber = matrix[rows][cols] + matrix[rows][cols + 1]
                        + matrix[rows + 1][cols] + matrix[rows + 1][cols + 1];

                if (currentNumber > max) {
                    max = currentNumber;
                    resultMatrix[0][0] = matrix[rows][cols];
                    resultMatrix[0][1] = matrix[rows][cols + 1];
                    resultMatrix[1][0] = matrix[rows + 1][cols];
                    resultMatrix[1][1] = matrix[rows + 1][cols + 1];
                }
            }

        }

        for (int rows = 0; rows < resultMatrix.length; rows++) {

            for (int cols = 0; cols < resultMatrix[rows].length; cols++) {

                System.out.print(resultMatrix[rows][cols] + " ");
            }
            System.out.println();
        }

        System.out.println(max);

    }

    public static int[][] readMatrix(Scanner scan) {

        String[] input = scan.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            String[] tokens = scan.nextLine().split(", ");
            for (int j = 0; j < tokens.length; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        return matrix;
    }
}
