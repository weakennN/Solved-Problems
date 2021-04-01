package MultidimensionalArrays;

import java.util.Scanner;

public class ParkingSystem {

    public static class CurrentSpot {

        static int carRow;
        static int carCol;
        static int parkRow;
        static int parkCol;

    }

    static int countTurns = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = readMatrix(scan);
        driveHorizontal(matrix);
        driveVertical(matrix);
        System.out.println("Your car reached the destination within " + countTurns + " turns.");

    }

    public static char[][] readMatrix(Scanner scan) {

        int rows = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[rows][rows];

        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            for (int col = 0; col < line.length(); col++) {

                if (line.charAt(col) == 'c') {
                    CurrentSpot.carCol = col;
                    CurrentSpot.carRow = row;
                } else if (line.charAt(col) == 'p') {
                    CurrentSpot.parkRow = row;
                    CurrentSpot.parkCol = col;
                }

                matrix[row][col] = line.charAt(col);

            }
        }

        return matrix;

    }

    public static void driveVertical(char[][] matrix) {
        int plus = 1;
        if (CurrentSpot.carRow > CurrentSpot.parkRow) {
            plus = -1;
        }

        while (CurrentSpot.carRow != CurrentSpot.parkRow) {

            matrix[CurrentSpot.carRow][CurrentSpot.carCol] = '*';
            CurrentSpot.carRow += plus;
            matrix[CurrentSpot.carRow][CurrentSpot.carCol] = 'c';
            countTurns++;
        }
    }

    public static void driveHorizontal(char[][] matrix) {
        int plus = 1;
        if (CurrentSpot.carCol > CurrentSpot.parkCol) {
            plus = -1;
        }

        while (CurrentSpot.carCol != CurrentSpot.parkCol) {

            matrix[CurrentSpot.carRow][CurrentSpot.carCol] = '*';
            CurrentSpot.carCol += plus;
            matrix[CurrentSpot.carRow][CurrentSpot.carCol] = 'c';
            countTurns++;
        }

    }
}
