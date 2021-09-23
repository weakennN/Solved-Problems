package MultidimensionalArrays;

import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scan);
        int[][] secondMatrix = readMatrix(scan);

        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            System.out.println("not equal");
            return;
        }

        for (int rows = 0; rows < firstMatrix.length; rows++) {

            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                if (firstMatrix[rows][cols] != secondMatrix[rows][cols]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
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
}

