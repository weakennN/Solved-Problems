package JavaFundamentals.MapsLambdaAndStreamAPIExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> results = new TreeMap<>();
        Map<String, Integer> submissions = new TreeMap<>();

        String com = scan.nextLine();

        while (!com.equals("exam finished")) {

            String[] info = com.split("-");

            if (info[1].equals("banned")) {
                if (results.containsKey(info[0])) {
                    results.remove(info[0]);
                    break;
                }
            }

            int points = Integer.parseInt(info[2]);

            results.put(info[0], points);

            if (submissions.containsKey(info[1])) {
                submissions.put(info[1], submissions.get(info[1]) + 1);
            } else {
                submissions.put(info[1], 1);
            }
            com = scan.nextLine();
        }

        System.out.println("Results:");
        results.entrySet().stream()
                .sorted((g1, g2) -> Integer.compare(g2.getValue(), g1.getValue()))
                .forEach(e -> System.out.println(String.format("%s | %d", e.getKey(), e.getValue())));
        System.out.println("Submissions:");
        submissions.entrySet().stream()
                .sorted((l, r) -> r.getValue().compareTo(l.getValue()))
                .forEach(e -> System.out.println(String.format("%s - %d", e.getKey(), e.getValue())));
    }

}
