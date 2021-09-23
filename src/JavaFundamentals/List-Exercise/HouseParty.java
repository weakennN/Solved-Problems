package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> name = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scan.nextLine();
            String[] com = command.split(" ");
            String guests = com[0];

            if (com[1].equals("is") && com[2].equals("not")) {

                if (name.contains(guests)) {
                    name.remove(guests);
                } else {
                    System.out.printf("%s is not in the list!%n", guests);
                }
            } else {
                if (!name.contains(guests)) {
                    name.add(guests);
                } else {
                    System.out.printf("%s is already in the list!%n", guests);
                }
            }


        }
        for (String parts : name) {
            System.out.println(parts);
        }

    }
}
