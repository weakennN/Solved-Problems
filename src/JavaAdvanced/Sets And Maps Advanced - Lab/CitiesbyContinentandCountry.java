package SetsAntMaps;

import java.util.*;

public class CitiesbyContinentandCountry {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");

            String continent = info[0];
            String country = info[1];
            String city = info[2];

            if (!map.containsKey(continent)) {
                List<String> a = new ArrayList<>();
                Map<String, List<String>> b = new LinkedHashMap<>();
                a.add(city);
                b.put(country, a);
                map.put(continent, b);
            } else {

                if (map.get(continent).containsKey(country)) {
                    List<String> a = map.get(continent).get(country);
                    a.add(city);
                } else {
                    Map<String, List<String>> a = map.get(continent);
                    List<String> b = new ArrayList<>();
                    b.add(city);
                    a.put(country, b);
                }

            }

        }

        map.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");

                    entry.getValue().entrySet().stream()
                            .forEach(innerE -> System.out.printf("  %s -> %s %n", innerE.getKey(),
                                    String.join(", ", innerE.getValue())));
                });


    }
}