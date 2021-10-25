package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SumWithLimitedAmountOfCoins {

    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] coins = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(scan.nextLine());
        used = new boolean[coins.length];
        System.out.println(sumWithCoins(coins, target, 0));
    }

    private static int sumWithCoins(int[] coins, int target, int index) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }

        int total = 0;
        for (int i = index; i < coins.length; i++) {
            if (!used[i]) {
                int current = sumWithCoins(coins, target - coins[i], i + 1);
                if (current >= 1) {
                    total += current;
                    used[index] = true;
                }
            }
        }

        return total;
    }
}
