package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllPathsInALabyrinth {

    public static class Position {

        Position(int row, int col) {

            this.row = row;
            this.col = col;
        }

        int row;
        int col;
    }

    public static char[][] labyrinth;
    public static final List<Character> path = new ArrayList<>();
    public static List<Position> markedPositions = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        labyrinth = readMatrix(scan);
        findPath(0, 0, 'a');

    }

    private static char[][] readMatrix(Scanner scan) {

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            String[] input = scan.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {

                matrix[i][j] = input[0].charAt(j);
            }
        }

        return matrix;
    }

    private static void findPath(int row, int col, char direction) {

        if (outOfBounds(row, col)) {

            return;
        }

        path.add(direction);

        if (isExit(row, col)) {
            printPath();
        } else if (!isVisited(row, col)) {

            markedPositions.add(new Position(row, col));
            findPath(row, col + 1, 'R');
            findPath(row + 1, col, 'D');
            findPath(row, col - 1, 'L');
            findPath(row - 1, col, 'U');
            unMark(row, col);

        }

        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }

    }

    private static boolean isExit(int row, int col) {

        if (labyrinth[row][col] == 'e') {

            return true;
        }

        return false;
    }

    private static boolean outOfBounds(int row, int col) {

        if (row >= labyrinth.length || row < 0 || col >= labyrinth[0].length || col < 0) {

            return true;
        }

        if (labyrinth[row][col] == '*') {

            return true;
        }

        return false;
    }

    private static void printPath() {

        for (int i = 0; i < path.size(); i++) {

            if (path.get(i) == 'a') {
                continue;
            }

            System.out.print(path.get(i));
        }

        System.out.println();
    }

    private static boolean isVisited(int row, int col) {

        for (int i = 0; i < markedPositions.size(); i++) {

            if (markedPositions.get(i).row == row && markedPositions.get(i).col == col) {

                return true;
            }
        }

        return false;
    }

    private static void unMark(int row, int col) {

        for (int i = 0; i < markedPositions.size(); i++) {

            if (markedPositions.get(i).row == row && markedPositions.get(i).col == col) {

                markedPositions.remove(markedPositions.get(i));
            }
        }
    }

}
