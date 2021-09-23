package SetsAntMaps;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, Map<String, Double>> shop = new TreeMap<>();


        String command = scan.nextLine();

        while (!command.equals("Revision")) {

            String[] info = command.split(", ");

            if (shop.containsKey(info[0])) {

                Map<String, Double> a = shop.get(info[0]);
                a.put(info[1], Double.parseDouble(info[2]));
                shop.put(info[0], a);
            } else {
                Map<String, Double> a = new LinkedHashMap<>();
                a.put(info[1], Double.parseDouble(info[2]));
                shop.put(info[0], a);
            }
            command = scan.nextLine();
        }

        shop.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");
                    entry.getValue().entrySet()
                            .stream()
                            .forEach(innerEntry -> {
                                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
                            });
                });
    }
}

