package SetsAntMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> keyItems = new LinkedHashMap<>();
        Map<String, Integer> junkItems = new TreeMap<>();

        keyItems.put("motes", 0);
        keyItems.put("shards", 0);
        keyItems.put("fragments", 0);

        boolean isObtained = false;

        while (!isObtained) {

            String[] info = scan.nextLine().toLowerCase().split("\\s+");
            if (isTrue(keyItems, junkItems, info)) {
                isObtained = true;
            }

        }

        keyItems.entrySet().stream()
                .sorted((l, r) -> {

                    if (r.getValue().compareTo(l.getValue()) == 0) {
                        return l.getKey().compareTo(r.getKey());
                    }
                    return r.getValue().compareTo(l.getValue());
                }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        for (Map.Entry<String, Integer> entry : junkItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static boolean isTrue(Map<String, Integer> keyItems, Map<String, Integer> junkItems, String[] info) {


        for (int i = 0; i < info.length; i += 2) {


            int quntity = Integer.parseInt(info[i]);

            if (info[i + 1].equals("motes") || info[i + 1].equals("shards") || info[i + 1].equals("fragments")) {

                keyItems.put(info[i + 1], keyItems.get(info[i + 1]) + quntity);

                if (isObtained(keyItems)) {
                    return true;
                }
            } else {
                if (!junkItems.containsKey(info[i + 1])) {
                    junkItems.put(info[i + 1], quntity);
                } else {
                    junkItems.put(info[i + 1], junkItems.get(info[i + 1]) + quntity);
                }
            }
        }
        return false;
    }

    public static boolean isObtained(Map<String, Integer> keyItems) {

        if (keyItems.get("motes") >= 250) {
            System.out.println("Dragonwrath obtained!");
            keyItems.put("motes", keyItems.get("motes") - 250);
            return true;
        } else if (keyItems.get("shards") >= 250) {
            System.out.println("Shadowmourne obtained!");
            keyItems.put("shards", keyItems.get("shards") - 250);
            return true;
        } else if (keyItems.get("fragments") >= 250) {
            System.out.println("Valanyr obtained!");
            keyItems.put("fragments", keyItems.get("fragments") - 250);
            return true;
        }
        return false;
    }
}
