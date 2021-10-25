package DynamicProgramming;

import java.util.*;

public class MoveDownRight {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        List<String> path = new ArrayList<>();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[rows][cols];

        dp[0][0] = matrix[0][0];

        for (int col = 1; col < cols; col++) {

            dp[0][col] = dp[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < rows; row++) {

            dp[row][0] = dp[row - 1][0] + matrix[row][0];
        }

        for (int row = 1; row < rows; row++) {

            for (int col = 1; col < cols; col++) {

                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + matrix[row][col];
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row > 0 || col > 0) {

            int left = -1;

            if (col > 0) {

                left = dp[row][col - 1];
            }

            int up = -1;

            if (row > 0) {

                up = dp[row - 1][col];
            }

            path.add(String.format("[%d, %d]", row, col));

            if (up > left) {

                row--;
            } else {

                col--;
            }

        }

        path.add("[0, 0]");
        Collections.reverse(path);

        System.out.println(String.join(" ", path));
    }
}
