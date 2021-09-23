package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class QueensPuzzle {

    private static final int boardHeight = 8;
    private static final int boardWidth = 8;
    private static List<Integer> queensPositions = new ArrayList<>();

    public static void main(String[] args) {

        findSolution(0);
    }

    private static void findSolution(int row) {

        if (row == 8) {

            printSolution();
            return;
        }

        for (int col = 0; col < boardWidth; col++) {

            if (canPlaceQueen(row, col)) {

                placeQueen(col);
                findSolution(row + 1);
                removeQueen();
            }
        }

    }

    private static boolean canPlaceQueen(int row, int col) {

        for (int i = 0; i < queensPositions.size(); i++) {

            if (col == queensPositions.get(i)) {

                return false;
            } else if (Math.abs(i - row) == Math.abs(queensPositions.get(i) - col)) {

                return false;
            }
        }

        return true;
    }

    private static void placeQueen(int col) {

        queensPositions.add(col);
    }

    private static void removeQueen() {

        queensPositions.remove(queensPositions.size() - 1);
    }

    private static void printSolution() {

        for (int row = 0; row < boardHeight; row++) {

            for (int col = 0; col < boardWidth; col++) {

                if (queensPositions.get(row) == col) {
                    System.out.print("* ");
                } else {

                    System.out.print("- ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}
