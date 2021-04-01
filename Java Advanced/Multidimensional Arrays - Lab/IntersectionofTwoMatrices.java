package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionofTwoMatrices {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = readCharMatrix(scan, rows, cols);
        char[][] secondMatrix = readCharMatrix(scan, rows, cols);

        char[][] thirdMatrix = new char[rows][cols];

        for (int i = 0; i < firstMatrix.length; i++) {

            for (int j = 0; j < firstMatrix[0].length; j++) {

                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    thirdMatrix[i][j] = '*';
                } else {
                    thirdMatrix[i][j] = firstMatrix[i][j];
                }
            }
        }

        for (int i = 0; i < thirdMatrix.length; i++) {

            for (int j = 0; j < thirdMatrix[0].length; j++) {
                System.out.print(thirdMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static char[][] readCharMatrix(Scanner scan, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            String[] tokens = scan.nextLine().split("\\s+");
            for (int j = 0; j < tokens.length; j++) {
                matrix[i][j] = tokens[j].charAt(0);
            }
        }
        return matrix;
    }
}