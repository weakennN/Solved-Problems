package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixofPalindromes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] matrix = palindromeMatrix(scan);
        printMatrix(matrix);

    }

    public static String[][] palindromeMatrix(Scanner scan) {

        String[] input = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        char firstLetter = 96;
        String[][] matrix = new String[rows][cols];

      /*  for (int i = 0; i < matrix.length; i++) {

            matrix[i][0] = firstLetter + "";
            matrix[i][0] += firstLetter + "";
            matrix[i][0] += firstLetter + "";
            firstLetter += 1;
        }


        firstLetter = 97;
       */

        for (int row = 0; row < matrix.length; row++) {

            char secondLetter = (char) (firstLetter + 1);

            for (int col = 0; col < matrix[row].length; col++) {

                matrix[row][col] = (char) (firstLetter + 1) + "";
                matrix[row][col] += secondLetter + "";
                matrix[row][col] += (char) (firstLetter + 1) + "";

                secondLetter += 1;
            }
            firstLetter += 1;
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
