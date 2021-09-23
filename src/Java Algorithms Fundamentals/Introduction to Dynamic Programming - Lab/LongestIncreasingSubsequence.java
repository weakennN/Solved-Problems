package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] sequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] len = new int[sequence.length + 1];
        int[] prev = new int[sequence.length + 1];

        Arrays.fill(prev, -1);

        int maxLength = 0;
        int bestIndex = -1;

        for (int i = 0; i < sequence.length; i++) {

            int bestLength = 1;
            int index = -1;

            for (int j = i - 1; j >= 0; j--) {

                if (bestLength <= len[j] + 1 && sequence[j] < sequence[i]) {

                    bestLength = len[j] + 1;
                    index = j;
                }
            }

            len[i] = bestLength;

            if (bestLength > maxLength) {

                maxLength = bestLength;
                bestIndex = i;
            }

            prev[i] = index;
        }

        List<Integer> path = new ArrayList<>();

        int num = bestIndex;

        while (num != -1) {

            path.add(sequence[num]);
            num = prev[num];
        }

        for (int i = path.size() - 1; i >= 0; i--) {

            System.out.print(path.get(i) + " ");
        }

    }
}
