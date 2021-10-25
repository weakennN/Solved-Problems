package DynamicProgramming;

import java.util.*;

public class Knapsack01 {

    static class Item implements Comparable<Item> {

        private String name;
        private int weight;
        private int price;

        public Item(String name, int weight, int price) {
            this.weight = weight;
            this.price = price;
            this.name = name;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getPrice() {
            return this.price;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public int compareTo(Item o) {
            return this.name.compareTo(o.getName());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int capacity = Integer.parseInt(scan.nextLine());
        List<Item> items = new ArrayList<>();
        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] parts = command.split("[\\s+]");
            items.add(new Item(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            command = scan.nextLine();
        }
    
        List<Item> result = fillKnapsack(items, capacity, 0);
        Collections.sort(result);
        System.out.println("Total Weight: " + getTotalWeight(result));
        System.out.println("Total Value: " + getTotalPrice(result));

        for (Item item : result) {
            System.out.println(item.getName());
        }
    }

    private static List<Item> fillKnapsack(List<Item> items, int capacity, int index) {
        if (capacity < 0) {
            return null;
        } else if (capacity == 0 || index >= items.size()) {
            return new ArrayList<>();
        }

        List<Item> max = new ArrayList<>();
        for (int i = index; i < items.size(); i++) {
            if (capacity - items.get(i).getWeight() >= 0) {
                List<Item> current = fillKnapsack(items, capacity - items.get(i).getWeight(), i + 1);
                if (current != null) {
                    current.add(items.get(i));
                    max = compare(current, max);
                }
            }
        }

        return max;
    }

    private static List<Item> compare(List<Item> first, List<Item> second) {
        int firstTotalPrice = getTotalPrice(first);
        int secondTotalPrice = getTotalPrice(second);

        if (firstTotalPrice >= secondTotalPrice) {
            return first;
        }

        return second;
    }

    private static int getTotalPrice(List<Item> items) {
        int totalPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            totalPrice += items.get(i).getPrice();
        }

        return totalPrice;
    }

    private static int getTotalWeight(List<Item> items) {
        int totalWeight = 0;
        for (int i = 0; i < items.size(); i++) {
            totalWeight += items.get(i).getWeight();
        }

        return totalWeight;
    }
}
