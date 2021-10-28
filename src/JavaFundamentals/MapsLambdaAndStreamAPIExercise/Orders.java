package JavaFundamentals.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class Orders {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();

        Map<String, List<Double>> orders = new LinkedHashMap<>();

        while (!com.equals("buy")) {

            String[] info = com.split(" ");

            double price = Double.parseDouble(info[1]);
            double quantity = Integer.parseInt(info[2]);

            if (orders.containsKey(info[0])) {
                List<Double> adding = orders.get(info[0]);
                adding.set(1, quantity + adding.get(1));
                adding.set(0, price * adding.get(1));
                orders.put(info[0], adding);
            } else {
                List<Double> adding = new ArrayList<>();
                adding.add(price * quantity);
                adding.add(quantity);
                orders.put(info[0], adding);
            }
            com = scan.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry : orders.entrySet()) {
            List<Double> a = entry.getValue();
            for (int i = 0; i < 1; i++) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), a.get(i));
            }
        }

    }
}
