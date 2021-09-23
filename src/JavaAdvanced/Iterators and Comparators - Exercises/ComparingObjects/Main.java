package IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        List<Person> person = new ArrayList<>();

        while (!command.equals("END")) {

            String[] input = command.split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String town = input[2];

            Person newPerson = new Person(name, age, town);
            person.add(newPerson);

            command = scan.nextLine();
        }

        int personToTake = Integer.parseInt(scan.nextLine());

        Person currentPerson = person.get(personToTake - 1);
        person.remove(personToTake - 1);
        int countIdentical = 0;
        int countNonIdentical = 0;
        for (int i = 0; i < person.size(); i++) {

            Person person1 = person.get(i);

            if (currentPerson.compareTo(person1) == 0) {
                countIdentical++;
            } else {
                countNonIdentical++;
            }

        }

        if (countIdentical == 0) {
            System.out.println("No matches");
            return;
        }

        System.out.println(countIdentical + 1 + " " + countNonIdentical + " " + (person.size() + 1) );
    }
}
