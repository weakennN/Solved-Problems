package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderbyAge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<OrderbyAgeInfo> people = new ArrayList<>();

        String com = scan.nextLine();

        while (!com.equals("End")) {

            String[] info = com.split(" ");

            int age = Integer.parseInt(info[2]);

            OrderbyAgeInfo person = new OrderbyAgeInfo(info[0], info[1], age);

            people.add(person);

            com = scan.nextLine();
        }

        people.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(p -> System.out.println(p));
    }
}
