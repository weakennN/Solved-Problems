package SetsAntMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String user = scan.nextLine();

            usernames.add(user);
        }

        for (String name : usernames) {
            System.out.println(name);
        }

    }
}
