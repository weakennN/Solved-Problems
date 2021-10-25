import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequenceIterative {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] len = new int[nums.length];
        int[] prev = new int[nums.length];
        int bestIndex = 0;
        int bestLength = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                    if (len[i] > bestLength) {
                        bestLength = len[i];
                        bestIndex = i;
                    }
                }
            }
        }

        int prevNumber = bestIndex;
        List<Integer> result = new ArrayList<>();
        while (prev[prevNumber] != -1) {
            result.add(nums[prevNumber]);
            prevNumber = prev[prevNumber];
        }
        result.add(nums[prevNumber]);

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }

        long finishTime = System.currentTimeMillis();
        System.out.println("That took: " + (finishTime - startTime) + " ms");
    }
}
