import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {
    private static int[] bestPrice;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] prices = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = Integer.parseInt(scan.nextLine());
        int[] bestCombo = new int[length + 1];
        bestPrice = new int[length + 1];
        System.out.println(rodCutting(prices, length, bestCombo));
        while (length - bestCombo[length] > 0){
            System.out.print(bestCombo[length] + " ");
            length = length - bestCombo[length];
        }
        System.out.print(bestCombo[length]);
    }

    private static int rodCutting(int[] prices, int length, int[] bestCombo) {
        if (bestPrice[length] > 0){
            return bestPrice[length];
        }
        if (length <= 0) {
            return prices[0];
        }

        int max = bestPrice[length];
        for (int i = 1; i <= length; i++) {
            int currentMax = Math.max(max, rodCutting(prices, length - i, bestCombo) + prices[i]);
            if (currentMax > max) {
                max = currentMax;
                bestCombo[length] = i;
                bestPrice[length] = max;
            }
        }

        return bestPrice[length];
    }
}
