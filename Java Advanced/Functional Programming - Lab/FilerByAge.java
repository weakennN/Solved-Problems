package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilerByAge {

    private static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {

            this.name = name;
            this.age = age;

        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] input = scan.nextLine().split(", ");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            people.add(person);
        }

        String condition = scan.nextLine();

        int ageCondition = Integer.parseInt(scan.nextLine());

        String printCondition = scan.nextLine();

        Predicate<Person> predicate = predicate(condition, ageCondition);

        Function<Person,String> print = printFormat(printCondition);

        people.stream()
                .filter(predicate)
                .forEach(e -> System.out.println(print.apply(e)));
    }

    public static Predicate<Person> predicate(String condition, int ageCondition) {


        if (condition.equals("older")) {
            return p -> p.age >= ageCondition;
        }

        return p -> p.age <= ageCondition;
    }

    public static Function<Person, String> printFormat(String printCondition) {

        if (printCondition.equals("age")) {
            return p -> p.age + "";
        } else if (printCondition.equals("name")) {
            return p -> p.name;
        }

        return p -> p.name + " - " + p.age;

    }
}
