package SetsAntMaps;

import java.util.*;

public class AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            double grade = Double.parseDouble(info[1]);

            if (students.containsKey(name)) {

                List<Double> a = students.get(name);
                a.add(grade);
                students.put(name, a);
            } else {
                List<Double> a = new ArrayList<>();
                a.add(grade);
                students.put(name, a);
            }
        }


    }
}
