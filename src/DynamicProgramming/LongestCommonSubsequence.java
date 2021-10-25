package DynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class LongestCommonSubsequence {
    private static HashMap<String, Integer> memo = new HashMap<>();
    private static int counter = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstWord = scan.nextLine();
        String secondWord = scan.nextLine();
        System.out.println(lcs(firstWord, secondWord));
    }

    private static int lcs(String first, String second) {
        System.out.println(++counter);
        String key = first + " " + second;
        if (memo.containsKey(key)) {
            return memo.get(key);
        } else if (first.length() == 0 || second.length() == 0) {
            return 0;
        }

        if (first.charAt(0) == second.charAt(0)) {
            memo.put(key, 1 + lcs(first.substring(1), second.substring(1)));
            return memo.get(key);
        }

        memo.put(key, Math.max(lcs(first.substring(1), second), lcs(first, second.substring(1))));
        return memo.get(key);
    }
}