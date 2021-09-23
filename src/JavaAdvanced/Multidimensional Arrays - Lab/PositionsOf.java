package MultidimensionalArrays;

import java.util.Scanner;

public class PositionsOf {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] firstMatrix = Read.readMatrix(scan);
        int n = Integer.parseInt(scan.nextLine());
        boolean flag = false;
        for (int rows = 0; rows < firstMatrix.length; rows++) {

            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                if (firstMatrix[rows][cols] == n) {
                    System.out.printf("%d %d%n", rows, cols);
                    flag = true;
                }
            }
        }

        if (!flag) {
            System.out.println("not found");
        }

    }


}
