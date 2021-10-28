package JavaFundamentals.MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        Map<Character, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) != (char) 32) {

                if (count.containsKey(word.charAt(i))) {
                    count.put(word.charAt(i), count.get(word.charAt(i)) + 1);
                } else {
                    count.put(word.charAt(i), 1);
                }
            }

        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
