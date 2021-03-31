package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        Pattern pattern = Pattern.compile("\\+359([ \\-])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher match = pattern.matcher(text);

        List<String> a = new ArrayList<>();
        while (match.find()) {
            a.add(match.group());
        }
        System.out.println(a.toString().replaceAll("[\\[\\]]", ""));

    }
}
