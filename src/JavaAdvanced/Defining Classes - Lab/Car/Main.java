package MoreClasses;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Employee>> employees = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");

            double salary = Double.parseDouble(info[1]);

            Employee employee;

            if (info.length == 6) {
                int age = Integer.parseInt(info[5]);
                employee = new Employee(info[0], salary, info[2], info[4], age);

            } else if (info.length == 4) {
                employee = new Employee(info[0], salary, info[2]);

            } else if (Character.isDigit(info[4].charAt(0))) {
                int age = Integer.parseInt(info[4]);
                employee = new Employee(info[0], salary, info[2], age);

            } else {
                employee = new Employee(info[0], salary, info[2], info[4]);

            }

            if (!employees.containsKey(info[3])) {
                List<Employee> a = new ArrayList<>();
                a.add(employee);
                employees.put(info[3], a);
            } else {
                employees.get(info[3]).add(employee);

            }

        }

        double sum = 0;
        double maxAverage = Double.MIN_VALUE;
        String highestDep = "";

        for (Map.Entry<String, List<Employee>> entry : employees.entrySet()) {

            List<Employee> a = entry.getValue();

            for (int i = 0; i < a.size(); i++) {
                Employee b = a.get(i);
                sum += b.getSalary();
            }
            sum /= a.size();
            if (sum > maxAverage) {
                maxAverage = sum;
                highestDep = entry.getKey();
            }
            sum = 0;

        }

        System.out.printf("Highest Average Salary: %s%n", highestDep);

        final String dep = highestDep;

        employees.get(dep).stream()
                .sorted((l, r) -> Double.compare(r.getSalary(), l.getSalary()))
                .forEach(e -> System.out.println(e.toString()));

    }


}
