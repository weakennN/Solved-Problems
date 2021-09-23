package AssociativeArrays;

import java.util.*;

public class CompanyUsers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> companies = new LinkedHashMap<>();

        String com = scan.nextLine();

        while (!com.equals("End")) {

            String[] info = com.split("->");

            if (companies.containsKey(info[0])) {

                List<String> a = companies.get(info[0]);
                if (!a.contains(info[1])) {
                    a.add(info[1]);
                }
            } else {
                List<String> a = new ArrayList<>();
                a.add(info[1]);
                companies.put(info[0], a);
            }
            com = scan.nextLine();
        }

        companies.entrySet().stream()
                .sorted((l, r) -> l.getKey().compareTo(r.getKey()))
                .forEach(e -> {
                    System.out.println(String.format(e.getKey()));
                    e.getValue().forEach(b -> System.out.println(String.format("--%s", b)));
                });
    }
}
