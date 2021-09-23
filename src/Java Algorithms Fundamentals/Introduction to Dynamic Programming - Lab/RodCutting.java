package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {

    public static int[] price;
    public static int[] bestCombo;
    public static int[] bestPrice;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        price = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        bestCombo = new int[price.length];
        bestPrice = new int[price.length];

        int roadLength = Integer.parseInt(scan.nextLine());

        System.out.println(cutRod(roadLength));

        while (roadLength - bestCombo[roadLength] != 0) {

            System.out.print(bestCombo[roadLength] + " ");
            roadLength = roadLength - bestCombo[roadLength];

        }

        System.out.println(bestCombo[roadLength]);

    }

    private static int cutRod(int n) {

        for (int i = 1; i <= n; i++) {

            int currentBest;

            for (int j = 1; j <= i; j++) {
                currentBest =
                        Math.max(bestPrice[i], price[j] + bestPrice[i - j]);

                if (currentBest > bestPrice[i]) {
                    bestPrice[i] = currentBest;
                    bestCombo[i] = j;
                }

            }
        }
        return bestPrice[n];
    }

}

