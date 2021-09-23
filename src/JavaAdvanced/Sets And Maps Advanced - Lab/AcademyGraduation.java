package SetsAntMaps;

import java.util.*;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println((3.75 + 5) / 2);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();
        double average = 0;
        for (int i = 0; i < n; i++) {

            String name = scan.nextLine();
            String[] grades = scan.nextLine().split("\\s+");
            List<Double> a = new ArrayList<>();
            for (int j = 0; j < grades.length; j++) {
                double g = Double.parseDouble(grades[j]);
                a.add(g);
                average += g;

            }

            System.out.printf("%s is graduated with %f%n", name, average / a.size());
            average = 0;
            students.put(name, a);
        }


    }
}
