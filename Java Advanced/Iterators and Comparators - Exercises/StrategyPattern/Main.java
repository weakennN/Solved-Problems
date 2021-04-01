package IteratorsAndComparators.StrategyPattern;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<Person> peopleComperator1 = new TreeSet<>(new Comperator1());
        TreeSet<Person> peopleComperator2 = new TreeSet<>(new Comperator2());

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] input = scan.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            peopleComperator1.add(person);
            peopleComperator2.add(person);
        }

        for (Person person : peopleComperator1) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        for (Person person : peopleComperator2) {
            System.out.println(person.getName() + " " + person.getAge());
        }

    }
}
