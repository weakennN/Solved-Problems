package JavaFundamentals.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class StudentAcademy {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            if (students.containsKey(name)) {
                List<Double> a = students.get(name);
                a.add(grade);
            } else {
                List<Double> a = new ArrayList<>();
                a.add(grade);
                students.put(name, a);
            }
        }

        students.entrySet().stream().filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((l, r) -> {
                    double first = l.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = r.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second, first);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f",
                        s.getKey(), s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())));


    }
}
