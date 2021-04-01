package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        String[] rotate = scan.nextLine().split("[()]+");
        int rotation = Integer.parseInt(rotate[1]) % 360;
        String input = scan.nextLine();
        int maxLen = 0;

        while (!input.equals("END")) {
            list.add(input);

            if (input.length() >= maxLen) {
                maxLen = input.length();
            }
            input = scan.nextLine();
        }

        char[][] matrix = readMatrix(list.size(), maxLen, list);

        checkRotation(rotation, maxLen, list, matrix);

    }

    public static void checkRotation(int rotation, int maxLen, List<String> list, char[][] matrix) {

        if (rotation == 90) {
            char[][] result = rotate90(matrix, maxLen);
            printMatrix(result);
        } else if (rotation == 180) {
            rotate180(matrix, maxLen);
        } else if (rotation == 270) {
            rotate270(matrix, maxLen);
        } else if (rotation == 0) {
            printMatrix(matrix);
        }

    }

    public static char[][] readMatrix(int rows, int cols, List<String> list) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < list.size(); row++) {

            for (int col = 0; col < cols; col++) {

                if (col < list.get(row).length()) {
                    matrix[row][col] = list.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }

            }
        }

        return matrix;
    }

    public static char[][] rotate90(char[][] matrix, int maxLen) {

        char[][] resultMatrix = new char[maxLen][matrix.length];

        for (int first = 0; first < maxLen; first++) {

            for (int second = 0; second < matrix.length; second++) {

                resultMatrix[first][second] = matrix[matrix.length - second - 1][first];

            }
        }
        return resultMatrix;
    }

    public static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void rotate180(char[][] matrix, int maxLen) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < maxLen; col++) {

                System.out.print(matrix[matrix.length - row - 1][maxLen - 1 - col]);
            }
            System.out.println();
        }
    }

    public static void rotate270(char[][] matrix, int maxLen) {

        for (int col = 0; col < maxLen; col++) {

            for (int row = 0; row < matrix.length; row++) {

                System.out.print(matrix[row][maxLen - col - 1]);
            }
            System.out.println();
        }

    }
}
