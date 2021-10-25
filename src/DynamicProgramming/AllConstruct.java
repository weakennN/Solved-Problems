package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class AllConstruct {

    public static void main(String[] args) {
        HashMap<String, ArrayList<ArrayList<String>>> memo = new HashMap<>();
        print(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, memo));
        print(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}, memo));
        //print(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaz", new String[]{"a", "aa", "aaa", "aaaa"}, memo));
    }

    private static ArrayList<ArrayList<String>> allConstruct(String target, String[] words, HashMap<String, ArrayList<ArrayList<String>>> memo) {
        if (memo.containsKey(target)) {
            return copy(memo.get(target));
        } else if (target.length() <= 0) {
            ArrayList<ArrayList<String>> way = new ArrayList<>();
            way.add(new ArrayList<>());
            return way;
        }

        ArrayList<ArrayList<String>> ways = null;
        for (int i = 0; i < words.length; i++) {
            if (target.startsWith(words[i])) {
                ArrayList<ArrayList<String>> way = allConstruct(target.substring(words[i].length()), words, memo);
                if (way != null) {
                    if (ways == null) {
                        ways = new ArrayList<>();
                    }
                    for (int j = 0; j < way.size(); j++) {
                        way.get(j).add(words[i]);
                    }
                    ways.addAll(way);
                }
            }
        }

        memo.put(target, copy(ways));

        return ways;
    }

    private static void print(ArrayList<ArrayList<String>> solutions) {
        if (solutions == null) {
            System.out.println("null");
            return;
        }

        for (int i = 0; i < solutions.size(); i++) {
            for (int j = solutions.get(i).size() - 1; j >= 0; j--) {
                System.out.print(solutions.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<String>> copy(ArrayList<ArrayList<String>> copyFrom) {
        if (copyFrom == null) {
            return null;
        }

        ArrayList<ArrayList<String>> newList = new ArrayList<>();
        for (int i = 0; i < copyFrom.size(); i++) {
            newList.add(new ArrayList<>());
            for (int j = 0; j < copyFrom.get(i).size(); j++) {
                newList.get(newList.size() - 1).add(copyFrom.get(i).get(j));
            }
        }

        return newList;
    }
}
