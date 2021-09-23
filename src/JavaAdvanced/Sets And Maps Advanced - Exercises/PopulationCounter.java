package SetsAntMaps;

import java.util.*;

public class PopulationCounter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> countries = new LinkedHashMap<>();

        List<Long> population = new ArrayList<>();

        String country = scan.nextLine();

        while (!country.equals("report")) {

            String[] info = country.split("\\|");

            int people = Integer.parseInt(info[2]);
            if (!countries.containsKey(info[1])) {
                Map<String, Integer> a = new LinkedHashMap<>();
                a.put(info[0], people);
                countries.put(info[1], a);
            } else {
                Map<String, Integer> a = countries.get(info[1]);

                if (a.containsKey(info[0])) {
                    a.put(info[0], a.get(info[0]) + people);
                } else {
                    a.put(info[0], people);
                }
            }
            country = scan.nextLine();
        }

        int counter = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : countries.entrySet()) {

            Map<String, Integer> a = countries.get(entry.getKey());

            for (Map.Entry<String, Integer> innerEntry : a.entrySet()) {
                population.add(counter, (long) innerEntry.getValue());
            }
            counter++;
        }


    }
}
