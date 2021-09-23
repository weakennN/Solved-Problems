package MultidimensionalArrays;

import java.util.Scanner;

public class Crossfire {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] matrix = readMatrix(scan);

        String command = scan.nextLine();
        while (!command.equals("Nuke it from orbit")) {

            String[] input = command.split("\\s+");

            int rowToNuke = Integer.parseInt(input[0]);
            int cowToNuke = Integer.parseInt(input[1]);
            int radius = Integer.parseInt(input[2]);

            vertical(matrix, rowToNuke, cowToNuke, radius, -1);
            vertical(matrix, rowToNuke, cowToNuke, radius, 1);
            horizontal(matrix, rowToNuke, cowToNuke, radius, -1);
            horizontal(matrix, rowToNuke, cowToNuke, radius, 1);

            command = scan.nextLine();
        }

        printMatrix(matrix);

    }

    public static void vertical(String[][] matrix, int rowToNuke, int colToNuke, int radius, int plus) {

        int cuttentRow = rowToNuke;
        for (int i = 0; i < radius + 1; i++, cuttentRow += plus) {

            if (cuttentRow >= matrix.length || cuttentRow < 0) {
                break;
            }
            matrix[cuttentRow][colToNuke] = "";
        }
    }

    public static void horizontal(String[][] matrix, int rowToNuke, int colToNuke, int radius, int plus) {

        int cuttentCol = colToNuke;
        for (int i = 0; i < radius + 1; i++, cuttentCol += plus) {

            if (cuttentCol >= matrix.length || cuttentCol < 0) {
                break;
            }
            matrix[rowToNuke][cuttentCol] = "";
        }
    }

    public static String[][] readMatrix(Scanner scan) {

        String[] input = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf(number);
                number++;
            }
        }
        return matrix;
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
