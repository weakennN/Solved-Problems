package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern patternNames = Pattern.compile("[A-Za-z]");
        Pattern patternDigits = Pattern.compile("\\d");

        Map<String, Integer> racers = new LinkedHashMap<>();
        String[] info = scan.nextLine().split(", ");
        for (int i = 0; i < info.length; i++) {

            racers.put(info[i], 0);
        }
        String text = scan.nextLine();

        while (!text.equals("end of race")) {
            StringBuilder sb = new StringBuilder();
            Matcher matchNames = patternNames.matcher(text);
            while (matchNames.find()) {
                sb.append(matchNames.group());
            }

            if (racers.containsKey(sb.toString())) {
                Matcher matchDigits = patternDigits.matcher(text);
                int km = racers.get(sb.toString());
                while (matchDigits.find()) {
                    int n = Integer.parseInt(matchDigits.group());
                    km += n;
                }
                racers.put(sb.toString(), km);
            }
            text = scan.nextLine();
        }

        List<String> a = new ArrayList<>();
        a.add("1st place: ");
        a.add("2nd place: ");
        a.add("3rd place: ");

        racers.entrySet().stream()
                .sorted((l, r) -> r.getValue().compareTo(l.getValue()))
                .limit(3)
                .forEach(e -> System.out.println(String.format(a.remove(0) + e.getKey())));

    }
}
