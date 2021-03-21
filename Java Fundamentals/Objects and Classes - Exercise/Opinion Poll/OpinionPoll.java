package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class OpinionPoll {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<OpinionPollinfo> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split(" ");
            int age = Integer.parseInt(info[1]);

            OpinionPollinfo person = new OpinionPollinfo(info[0], age);

            if (person.getAge() >= 30) {
                people.add(person);
            }
        }

        people.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
