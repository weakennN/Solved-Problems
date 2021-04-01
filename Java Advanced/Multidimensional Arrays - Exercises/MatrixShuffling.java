package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] matrix = readMatrix(scan);

        String command = scan.nextLine();

        while (!command.equals("END")) {
            String[] info = command.split("\\s+");
            if (info[0].equals("swap") && info.length == 5) {

                int row = Integer.parseInt(info[1]);
                int col = Integer.parseInt(info[2]);
                int row2 = Integer.parseInt(info[3]);
                int col2 = Integer.parseInt(info[4]);

                if (isValid(row, col, row2, col2, matrix)) {
                    String c = matrix[row][col];
                    matrix[row][col] = matrix[row2][col2];
                    matrix[row2][col2] = c;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = scan.nextLine();
        }


    }

    public static String[][] readMatrix(Scanner scan) {

        String[] input = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {

            String[] tokens = scan.nextLine().split("\\s+");
            for (int j = 0; j < tokens.length; j++) {
                matrix[i][j] = tokens[j];
            }
        }
        return matrix;
    }

    public static boolean isValid(int row, int col, int row2, int col2, String[][] matrix) {

        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && row2 >= 0 &&
                row2 < matrix.length && col2 >= 0 && col2 < matrix[row2].length) {
            return true;
        }
        return false;
    }

    public static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
