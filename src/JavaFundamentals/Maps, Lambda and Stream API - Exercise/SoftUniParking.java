package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, String> regPeople = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String com = scan.nextLine();
            String[] info = com.split(" ");

            if (info[0].equals("register")) {
                if (regPeople.containsKey(info[1])) {
                    System.out.printf("ERROR: already registered with plate number %s%n", regPeople.get(info[1]));
                } else {
                    regPeople.put(info[1], info[2]);
                    System.out.printf("%s registered %s successfully%n", info[1], info[2]);
                }

            } else if (info[0].equals("unregister")) {
                if (!regPeople.containsKey(info[1])) {
                    System.out.printf("ERROR: user %s not found%n", info[1]);
                } else {
                    System.out.printf("%s unregistered successfully%n", info[1]);
                    regPeople.remove(info[1]);
                }
            }
        }

        for (Map.Entry<String, String> entry : regPeople.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
