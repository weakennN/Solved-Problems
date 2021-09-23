package GraphTheoryTraversalAndShortestPaths;

import java.util.Scanner;

public class TheMatrix {

    public static char fillChar;
    public static char startChar;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] matrix = readMatrix(scan);

        fillChar = scan.nextLine().charAt(0);
        String[] indexes = scan.nextLine().split("\\s+");
        int startRow = Integer.parseInt(indexes[0]);
        int startCol = Integer.parseInt(indexes[1]);

        startChar = matrix[startRow][startCol];
        fillMatrix(startRow, startCol, matrix);
        printMatrix(matrix);
    }

    public static char[][] readMatrix(Scanner scan) {

        String[] indexes = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(indexes[0]);
        int cols = Integer.parseInt(indexes[1]);

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            String[] line = scan.nextLine().split("\\s+");

            for (int j = 0; j < line.length; j++) {

                matrix[i][j] = line[j].charAt(0);
            }
        }

        return matrix;
    }

    public static void fillMatrix(int row, int col, char[][] matrix) {

        if (isOutOfBounds(row, col, matrix)) {

            return;
        }

        matrix[row][col] = fillChar;

        fillMatrix(row, col + 1, matrix);
        fillMatrix(row + 1, col, matrix);
        fillMatrix(row, col - 1, matrix);
        fillMatrix(row - 1, col, matrix);
    }

    public static boolean isOutOfBounds(int row, int col, char[][] matrix) {

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {

            return true;
        } else if (matrix[row][col] == fillChar || matrix[row][col] != startChar) {

            return true;
        }

        return false;
    }

    public static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }
    }
}
