package JavaAlgorithmsFundamentals.SearchingSortingAndGreedyAlgorithmsLab;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int takenCoinsCounter = 0;

        String coinsAsString = scan.nextLine();

        Map<Integer, Integer> countCoins = new LinkedHashMap<>();

        coinsAsString = coinsAsString.substring(7);

        List<Integer> coins = Arrays.stream(coinsAsString.split(", +"))
                .map(Integer::parseInt)
                .sorted((l, r) -> Integer.compare(r, l))
                .collect(Collectors.toList());


        String sumAsString = scan.nextLine().substring(5);
        int sum = Integer.parseInt(sumAsString);
        int testSum = 0;

        while (testSum < sum) {

            if (testSum + coins.get(0) > sum) {

                coins.remove(0);

                if (coins.size() < 1) {

                    break;
                }
                continue;
            }

            testSum += coins.get(0);
            countCoins.putIfAbsent(coins.get(0), 0);
            countCoins.put(coins.get(0), countCoins.get(coins.get(0)) + 1);
            takenCoinsCounter++;
        }

        if (testSum != sum) {

            System.out.println("Error");
            return;
        }

        System.out.println("Number of coins to take: " + takenCoinsCounter);

        for (Map.Entry<Integer, Integer> entry : countCoins.entrySet()) {

            System.out.printf("%d coin(s) with value %d%n", entry.getValue(), entry.getKey());
        }
    }
}
