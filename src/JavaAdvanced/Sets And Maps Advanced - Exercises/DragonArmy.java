package SetsAntMaps;

import java.util.*;

public class DragonArmy {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, List<Double>>> dragons = new LinkedHashMap<>();
        Map<String, List<Double>> average = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] dragonsInfo = scan.nextLine().split("\\s+");

            String typeDragon = dragonsInfo[0];
            String dragonName = dragonsInfo[1];
            double health = defaultVal(dragonsInfo, 3, 250);
            double damage = defaultVal(dragonsInfo, 2, 45);
            double armor = defaultVal(dragonsInfo, 4, 10);

            if (!dragons.containsKey(typeDragon)) {
                List<Double> stats = new ArrayList<>();
                Map<String, List<Double>> dragon = new TreeMap<>();
                stats.add(damage);
                stats.add(health);
                stats.add(armor);
                dragon.put(dragonName, stats);
                dragons.put(typeDragon, dragon);

            } else {
                Map<String, List<Double>> innerDragons = dragons.get(typeDragon);

                List<Double> stats = new ArrayList<>();
                stats.add(damage);
                stats.add(health);
                stats.add(armor);
                innerDragons.put(dragonName, stats);

            }
        }

        for (Map.Entry<String, Map<String, List<Double>>> entry : dragons.entrySet()) {
            double sum = 0;
            int count = 0;
            Map<String, List<Double>> a = dragons.get(entry.getKey());
            List<Double> add = new ArrayList<>();
            for (int i = 0; i < 3; i++) {

                for (Map.Entry<String, List<Double>> entry3 : a.entrySet()) {
                    List<Double> b = a.get(entry3.getKey());
                    sum += b.get(i);
                    count++;
                }

                add.add(sum / count);
                average.put(entry.getKey(), add);
                sum = 0;
                count = 0;
            }
        }

        dragons.entrySet().stream()
                .forEach(d -> {

                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", d.getKey(), average.get(d.getKey()).remove(0),
                            average.get(d.getKey()).remove(0), average.get(d.getKey()).remove(0));

                    d.getValue().entrySet().stream()
                            .forEach(innerD -> {
                                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", innerD.getKey(), innerD.getValue().remove(0),
                                        innerD.getValue().remove(0), innerD.getValue().remove(0));
                            });
                });

    }

    public static double defaultVal(String[] dragonsInfo, int j, int def) {

        if (dragonsInfo[j].equals("null")) {
            return def;
        }
        return Double.parseDouble(dragonsInfo[j]);
    }

}
