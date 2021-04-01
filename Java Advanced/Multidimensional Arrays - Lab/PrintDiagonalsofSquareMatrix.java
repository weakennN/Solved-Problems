package MultidimensionalArrays;

import java.util.Scanner;

public class PrintDiagonalsofSquareMatrix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        int[][] resultMatrix = new int[2][matrix.length];

        for (int rows = 0; rows < matrix.length; rows++) {

            for (int cols = 0; cols < matrix.length; cols++) {

                if (cols == (matrix[0].length - 1) - rows) {
                    resultMatrix[1][cols] = matrix[rows][cols];
                }
                if (rows == cols) {
                    resultMatrix[0][cols] = matrix[rows][cols];
                }
            }
        }

        for (int rows = 0; rows < resultMatrix.length; rows++) {

            for (int cols = 0; cols < resultMatrix[0].length; cols++) {

                System.out.print(resultMatrix[rows][cols] + " ");
            }
            System.out.println();
        }


    }

    public static int[][] readMatrix(Scanner scan) {

        String[] input = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);

        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            String[] info = scan.nextLine().split("\\s+");
            for (int j = 0; j < rows; j++) {
                int parse = Integer.parseInt(info[j]);
                matrix[i][j] = parse;
            }
        }

        return matrix;
    }
}
