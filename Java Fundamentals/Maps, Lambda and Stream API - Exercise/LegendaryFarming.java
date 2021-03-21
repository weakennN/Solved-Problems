package AssociativeArrays;

import java.util.*;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("fragments", 0);
        items.put("motes", 0);
        items.put("shards", 0);
        String com = scan.nextLine().toLowerCase();

        while (!items.containsKey("Valanyr") || !items.containsKey("Shadowmourne") || !items.containsKey("Dragonwrath")) {

            String[] info = com.split(" ");

            for (int i = 0; i < info.length; i += 2) {
                int resource = Integer.parseInt(info[i]);
                if (items.containsKey(info[i + 1])) {
                    items.put(info[i + 1], items.get(info[i + 1]) + resource);
                } else {
                    items.put(info[i + 1], resource);
                }
            }

            if (checkIfObtained(items, "motes", "Dragonwrath")) {
                break;
            }
            if (checkIfObtained(items, "shards", "Shadowmourne")) {
                break;
            }
            if (checkIfObtained(items, "fragments", "Valanyr")) {
                break;
            }
            com = scan.nextLine().toLowerCase();
        }

        items.entrySet().stream().sorted((l, r) -> l.getKey().compareTo(r.getKey()))
                .forEach(e -> System.out.println(String.format("%s: %d", e.getKey(), e.getValue())));


    }

    public static boolean checkIfObtained(Map<String, Integer> items, String key, String toObtain) {
        if (items.containsKey(key)) {
            if (items.get(key) >= 250) {
                System.out.println(toObtain + " " + "obtained!");
                items.put(key, items.get(key) - 250);
                return true;
            }
        }
        return false;
    }


}