package CombinatorialProblems;

import java.util.*;

public class ConnectedAreasInAMatrix {

    public static class Position {

        int row;
        int col;
        int size;

        Position(int row, int col, int size) {

            this.row = row;
            this.col = col;
            this.size = size;
        }
    }

    public static List<Position> areas;
    public static String[][] matrix;
    public static int startRow;
    public static int startCol;
    public static int count = 0;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        matrix = readMatrix(scan);
        areas = new ArrayList<>();

        findStartRowAndCol();
        solution(startRow, startCol);

        System.out.println("Total areas found: " + areas.size());

        areas.stream().sorted((l, r) -> Integer.compare(r.size, l.size)).forEach(e -> System.out.println(String.format("Area #%d at (%d, %d), size: %d", ++count, e.row, e.col, e.size)));

    }

    public static String[][] readMatrix(Scanner scan) {

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {

            String line = scan.nextLine();
            for (int col = 0; col < cols; col++) {

                matrix[row][col] = line.charAt(col) + "";
            }
        }

        return matrix;
    }

    public static void solution(int row, int col) {

        if (isOutOfBound(row, col)) {

            return;
        }

        if (!matrix[row][col].equals("v")) {
            matrix[row][col] = "v";
            count++;
            solution(row, col + 1);  //Right
            solution(row + 1, col); // Down
            solution(row, col - 1); //Left
            solution(row - 1, col);//Up
        }

        if (count == 0) {
            return;
        }

        if (row == startRow && col == startCol) {

            areas.add(new Position(row, col, count));
            findStartRowAndCol();
            count = 0;
            solution(startRow, startCol);

        }

    }

    public static boolean isOutOfBound(int row, int col) {

        if (row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0 || matrix[row][col].equals("*")) {

            return true;
        }

        return false;
    }

    public static void findStartRowAndCol() {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[0].length; col++) {

                if (!matrix[row][col].equals("*") && !matrix[row][col].equals("v")) {

                    startRow = row;
                    startCol = col;
                    return;
                }
            }
        }
    }
}
