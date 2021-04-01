package SetsAntMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> people = new LinkedHashMap<>();
        String name = scan.nextLine();

        while (!name.equals("stop")) {

            String email = scan.nextLine();

            String[] info = email.split("\\.");

            if (!info[1].equals("us") && !info[1].equals("uk") && !info[1].equals("com")) {
                people.put(name, email);
            }
            name = scan.nextLine();
        }

        for (Map.Entry<String, String> entry : people.entrySet()) {

            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }

    }
}
