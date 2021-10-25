package RecursionAndBacktracking;

import java.util.Scanner;

public class RecursiveDrawing {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        System.out.println(drawTriangle(n));
    }

    public static String drawTriangle(int n) {
        StringBuilder str = new StringBuilder();

        if (n == 0) {

            return "";
        }

        for (int i = 0; i < n; i++) {

            str.append("*");
        }

        str.append('\n');

        str.append(drawTriangle(n - 1));

        for (int i = 0; i < n; i++) {

            str.append("#");
        }

        str.append("\n");

        return str.toString();
    }

}
