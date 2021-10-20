import java.util.Arrays;
import java.util.Scanner;

public class SumWithUnlimitedAmountOfCoins {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] coins = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(scan.nextLine());

        System.out.println(sumWithCoins(coins, target, 0));
    }

    private static int sumWithCoins(int[] coins, int target, int index) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }

        int amountTimes = 0;
        for (int i = index; i < coins.length; i++) {
            amountTimes += sumWithCoins(coins, target - coins[i], i);
        }

        return amountTimes;
    }
}
