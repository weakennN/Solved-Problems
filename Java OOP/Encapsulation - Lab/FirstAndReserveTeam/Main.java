package Encapsulation.FirstAndReserveTeam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Team team = new Team("Otbor");
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scan.nextLine().split("\\s+");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);

            Person person = new Person(firstName, lastName, age, salary);

            team.addPlayer(person);
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reverse team have %d players", team.getReserveTeam().size());


    }
}
