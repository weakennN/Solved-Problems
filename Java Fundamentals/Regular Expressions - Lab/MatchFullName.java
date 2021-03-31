package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(scan.nextLine());

        while(matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
