package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = readMatrix(scan);
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 'q') {

                    if (vertical(matrix, row + 1, col, 1) && vertical(matrix, row - 1, col, -1)) {

                        if (horizontal(matrix, row, col + 1, 1) && horizontal(matrix, row, col - 1, -1)) {

                            if (diagonal(matrix, row - 1, col + 1, -1, 1) &&
                                    diagonal(matrix, row - 1, col - 1, -1, -1)) {

                                if (diagonal(matrix, row + 1, col - 1, 1, -1) &&
                                        diagonal(matrix, row + 1, col + 1, 1, 1)) {

                                    System.out.println(row + " " + col);
                                }

                            }

                        }

                    }
                }
            }
        }

    }

    public static char[][] readMatrix(Scanner scan) {

        char matrix[][] = new char[8][8];


        for (int i = 0; i < matrix.length; i++) {

            String[] tokens = scan.nextLine().split("\\s+");
            for (int j = 0; j < tokens.length; j++) {

                matrix[i][j] = tokens[j].charAt(0);
            }
        }
        return matrix;
    }

    public static boolean vertical(char[][] matrix, int row, int col, int plus) {

        for (; row < matrix.length && row >= 0; row += plus) {

            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        return true;


    }

    public static boolean horizontal(char[][] matrix, int row, int col, int plus) {

        for (; col < matrix.length && col >= 0; col += plus) {

            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        return true;
    }

    public static boolean diagonal(char[][] matrix, int row, int col, int plus, int colPlus) {

        if (row <= 0 || col <= 0) {
            return true;
        }

        for (; row < matrix.length && row >= 0; row += plus, col += colPlus) {

            if (col == 0 || col >= matrix.length) {
                return true;
            }

            if (matrix[row][col] == 'q') {
                return false;
            }

        }
        return true;
    }

}
