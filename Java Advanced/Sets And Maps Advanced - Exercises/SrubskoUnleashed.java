package SetsAntMaps;

import java.util.*;

public class SrubskoUnleashed {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> concerts = new LinkedHashMap<>();

        String command = scan.nextLine();

        while (!command.equals("End")) {

            if (!command.contains("@") || command.charAt(command.indexOf("@") - 1) != ' ') {
                command = scan.nextLine();
                continue;
            }

            int index = 0;
            int tokensCount = 0;
            String location = "";
            String singer = "";

            for (int i = 0; i < command.length() - 1; i++) {

                if (command.charAt(i) == '@') {
                    index = i + 1;
                    singer = command.substring(0, i);
                    tokensCount++;

                } else if (command.charAt(i) == ' ' && Character.isDigit(command.charAt(i + 1))) {

                    if (tokensCount == 1) {
                        location = command.substring(index, i);
                    }

                    tokensCount++;
                }
            }

            if (tokensCount == 3) {
                String[] info1 = command.split("\\s+");

                int quantity = Integer.parseInt(info1[info1.length - 2]);
                int prize = Integer.parseInt(info1[info1.length - 1]);

                fillMap(concerts, location, singer, quantity, prize);

            }
            command = scan.nextLine();

        }

        concerts.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey());

                    e.getValue().entrySet().stream()
                            .sorted((l, r) -> {

                                if (r.getValue().compareTo(l.getValue()) == 0) {
                                    return l.getValue();
                                }
                                return r.getValue().compareTo(l.getValue());

                            }).forEach(b -> System.out.printf("#  %s-> %d%n", b.getKey(), b.getValue()));

                });

    }

    public static void fillMap(Map<String, Map<String, Integer>> concerts,
                               String location, String singer, int quantity, int prize) {

        if (!concerts.containsKey(location)) {

            Map<String, Integer> a = new LinkedHashMap<>();
            a.put(singer, prize * quantity);
            concerts.put(location, a);

        } else {
            Map<String, Integer> a = concerts.get(location);

            if (a.containsKey(singer)) {
                a.put(singer, a.get(singer) + (quantity * prize));
            } else {
                a.put(singer, quantity * prize);
            }
        }
    }

}
