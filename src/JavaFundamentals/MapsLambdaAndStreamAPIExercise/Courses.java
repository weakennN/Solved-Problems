package JavaFundamentals.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class Courses {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();

        Map<String, List<String>> courses = new HashMap<>();

        while (!com.equals("end")) {

            String[] info = com.split(" : ");

            courses.putIfAbsent(info[0], new ArrayList<>());
            List<String> a = courses.get(info[0]);
            a.add(info[1]);
            courses.put(info[0], a);

            com = scan.nextLine();
        }

        courses.entrySet().stream()
                .sorted((l, r) -> Integer.compare(r.getValue().size(), l.getValue().size()))
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue().size()));
                    e.getValue().stream().sorted((l, r) -> l.compareTo(r))
                            .forEach(s -> System.out.println(String.format("-- %s", s)));
                });

    }
}
