package SetsAntMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> ips = new TreeMap<>();
        String ip = scan.nextLine();

        while (!ip.equals("end")) {

            String[] info = ip.split("[ = ]");

            if (!ips.containsKey(info[5])) {
                Map<String, Integer> newIp = new LinkedHashMap<>();
                newIp.put(info[1], 1);
                ips.put(info[5], newIp);
            } else {
                Map<String, Integer> a = ips.get(info[5]);
                if (a.containsKey(info[1])) {
                    a.put(info[1], a.get(info[1]) + 1);
                } else {
                    Map<String, Integer> b = ips.get(info[5]);
                    b.put(info[1], 1);
                }
            }

            ip = scan.nextLine();
        }

        ips.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    e.getValue().entrySet().stream()
                            .forEach(inner -> {

                                System.out.printf("%s => %s", inner.getKey(),String.join(", ",inner.getValue() + ""));
                            });
                    System.out.print(".\n");
                });
    }
}
