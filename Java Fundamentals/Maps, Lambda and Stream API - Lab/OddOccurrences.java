package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OddOccurrences {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] info = scan.nextLine().toLowerCase().split(" ");

        Map<String, Integer> countTimes = new LinkedHashMap<>();

        for (int i = 0; i < info.length; i++) {
            if (countTimes.containsKey(info[i])) {
                countTimes.put(info[i], countTimes.get(info[i]) + 1);
            } else {
                countTimes.put(info[i], 1);
            }
        }

        String result = "";
        for (Map.Entry<String, Integer> a : countTimes.entrySet()) {

            if (a.getValue() % 2 != 0) {
                result += a.getKey() + ", ";
            }
        }

        if (result.length() > 2) {
            System.out.println(result.substring(0, result.length() - 2));
        }
    }
}
