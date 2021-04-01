package SetsAntMaps;

import java.util.*;

public class LogsAggregator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, TreeSet<String>> logs = new TreeMap<>();

        Map<String, Integer> value = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");

            String name = info[1];
            String ip = info[0];

            if (!logs.containsKey(name)) {
                TreeSet<String> a = new TreeSet<>();
                a.add(ip);
                logs.put(name, a);
                value.put(name, Integer.parseInt(info[2]));
            } else {
                TreeSet<String> a = logs.get(name);
                a.add(ip);
                value.put(name, value.get(name) + Integer.parseInt(info[2]));
            }
        }

        logs.entrySet().stream()
                .forEach(e -> {
                    System.out.printf("%s: %d %s%n", e.getKey(), value.remove(e.getKey()), e.getValue().toString());

                });

    }
}
