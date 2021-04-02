package Encapsulation.SortByNameAndAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person1> people = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scan.nextLine().split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            Person1 person1 = new Person1(firstName, lastName, age, salary);

            people.add(person1);
        }
            double bonus = (Double.parseDouble(scan.nextLine()) / 100);

        for (Person1 person1 : people) {
            person1.increaseSalary(bonus);
            System.out.println(person1.toString());
        }


    }
}
