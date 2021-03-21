package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String com = scan.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!com.equals("stop")) {

            int count = Integer.parseInt(scan.nextLine());
            if (resources.containsKey(com)) {
                resources.put(com, resources.get(com) + count);
            } else {
                resources.put(com, count);
            }

            com = scan.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
