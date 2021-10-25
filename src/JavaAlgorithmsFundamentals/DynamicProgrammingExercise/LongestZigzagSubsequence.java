package JavaAlgorithmsFundamentals.DynamicProgrammingExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class LongestZigzagSubsequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] sequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[sequence.length + 1][2];
        int[][] prev = new int[sequence.length + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        prev[0][0] = -1;
        prev[0][1] = -1;

        int maxLength = 0;
        int[] bestIndexes = new int[2];

        for (int i = 0; i < sequence.length; i++) {

            for (int j = i - 1; j >= 0; j--) {

                if (sequence[i] > sequence[j] && dp[i][0] <= dp[j][1] + 1) {

                    dp[i][0] = dp[j][1] + 1;
                    prev[i][0] = j;
                }
                if (sequence[i] < sequence[j] && dp[i][1] <= dp[j][0] + 1) {

                    dp[i][1] = dp[j][0] + 1;
                    prev[i][1] = j;
                }
            }

            if (maxLength < dp[i][0]) {

                maxLength = dp[i][0];
                bestIndexes[0] = i;
                bestIndexes[1] = 0;
            } else if (maxLength < dp[i][1]) {

                maxLength = dp[i][1];
                bestIndexes[0] = i;
                bestIndexes[1] = 1;
            }

        }

        Deque<Integer> output = new ArrayDeque<>();

        int beginRow = bestIndexes[0];

        while (beginRow >= 0) {

            output.push(sequence[beginRow]);
            beginRow = prev[beginRow][bestIndexes[1]];
            bestIndexes[1] = bestIndexes[1] == 0 ? 1 : 0;
        }

        while(!output.isEmpty()){

            System.out.print(output.pop() + " ");
        }

    }
}
