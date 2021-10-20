import java.util.*;

public class Knapsack01DP {

    private static class Item implements Comparable<Item> {

        public String name;
        public int weight;
        public int price;

        public Item(String name, int weight, int price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Item o) {
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = Integer.parseInt(scan.nextLine());
        List<Item> items = new ArrayList<>();

        while (true) {
            String item = scan.nextLine();

            if (item.equals("end")) {
                break;
            }

            String[] token = item.split("[\\s+]");
            items.add(new Item(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2])));
        }

        int[][] prices = new int[items.size() + 1][capacity + 1];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < prices[i].length; j++) {
                if (items.get(i - 1).weight <= j) {
                    prices[i][j] = Math.max(prices[i - 1][j], items.get(i - 1).price + prices[i - 1][j - items.get(i - 1).weight]);
                } else {
                    prices[i][j] = prices[i - 1][j];
                }
            }
        }

        List<Item> result = new ArrayList<>();

        int itemIndex = items.size();
        int currentCapacity = capacity;
        while (itemIndex > 0 && currentCapacity >= items.get(itemIndex - 1).weight) {
            if (prices[itemIndex][currentCapacity] - prices[itemIndex - 1][currentCapacity - items.get(itemIndex - 1).weight] == items.get(itemIndex - 1).price) {
                result.add(items.get(itemIndex - 1));
                currentCapacity -= items.get(itemIndex - 1).weight;
            }

            itemIndex--;
        }

        Collections.sort(result);
        System.out.println("Total Weight: " + result.stream().mapToInt(e -> e.weight).sum());
        System.out.println("Total Value: " + prices[items.size()][capacity]);
        for (Item item : result) {
            System.out.println(item.name);
        }
    }
}
