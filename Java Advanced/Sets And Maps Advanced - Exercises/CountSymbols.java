package SetsAntMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Character, Integer> timesSeen = new TreeMap<>();
        String word = scan.nextLine();

        for (int i = 0; i < word.length(); i++) {

            char letter = word.charAt(i);

            timesSeen.putIfAbsent(letter, 0);
            timesSeen.put(letter, timesSeen.get(letter) + 1);

        }

        for (Map.Entry<Character, Integer> letter : timesSeen.entrySet()) {
            String c = (char) letter.getKey() + "";
            System.out.println((c + ": " + letter.getValue() + " time/s"));
        }
    }
}
