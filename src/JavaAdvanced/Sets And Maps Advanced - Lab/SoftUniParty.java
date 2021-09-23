
package SetsAntMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();
        while (!command.equals("PARTY")) {

            int firstLetter = command.charAt(0);
            if (Character.isDigit(firstLetter)) {
                vip.add(command);
            } else {
                regular.add(command);
            }
            command = scan.nextLine();
        }

        command = scan.nextLine();

        while (!command.equals("END")) {

            vip.remove(command);
            regular.remove(command);

            command = scan.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        for (String v : vip) {
            System.out.println(v);
        }

        for (String v : regular) {
            System.out.println(v);
        }
    }
}
