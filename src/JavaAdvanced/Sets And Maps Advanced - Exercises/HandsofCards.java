package SetsAntMaps;

import java.util.*;

public class HandsofCards {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String command = scan.nextLine();

        while (!command.equals("JOKER")) {

            String name = command.split(": ")[0];
            String[] cards = command.split(": ")[1].split(", ");
            Set<String> deck = new LinkedHashSet<>(Arrays.asList(cards));

            if (!players.containsKey(name)) {
                players.put(name, deck);
            } else {
                Set<String> a = players.get(name);
                a.addAll(deck);
            }
            command = scan.nextLine();
        }

        Map<Character, Integer> powers = fillMapWithPowers();

        Map<Character, Integer> types = fillMapWithTypes();

        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            Set<String> a = players.get(entry.getKey());
            int sum = 0;
            for (String b : a) {
                char power = b.charAt(0);
                if (power == '1') {
                    String ten = b.substring(0, 2);
                    int n = Integer.parseInt(ten);
                    char type = b.charAt(2);
                    sum += n * types.get(type);
                    continue;
                }
                char type = b.charAt(1);

                sum += powers.get(power) * types.get(type);
            }

            System.out.printf("%s: %d%n", entry.getKey(), sum);
        }

    }

    public static Map<Character, Integer> fillMapWithPowers() {

        Map<Character, Integer> powers = new LinkedHashMap<>();

        for (int i = 50, j = 2; i < 58; i++, j++) {
            powers.put((char) i, j);

        }
        powers.put('J', 11);
        powers.put('Q', 12);
        powers.put('K', 13);
        powers.put('A', 14);

        return powers;
    }

    public static Map<Character, Integer> fillMapWithTypes() {

        Map<Character, Integer> types = new LinkedHashMap<>();

        types.put('S', 4);
        types.put('H', 3);
        types.put('D', 2);
        types.put('C', 1);

        return types;
    }

}
