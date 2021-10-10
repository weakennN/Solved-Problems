import java.util.HashMap;

public class CountConstruct {

    public static void main(String[] args) {
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef"
                , new String[]{"e", "ee", "eee", "eeeeeeeee", "eeee", "f"}, memo));
    }

    private static int countConstruct(String target, String[] words, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        } else if (target.length() <= 0) {
            return 1;
        }

        int countTimes = 0;
        for (int i = 0; i < words.length; i++) {
            if (target.length() >= words[i].length()) {
                if (target.startsWith(words[i])) {
                    countTimes += countConstruct(target.substring(words[i].length()), words, memo);
                }
            }
        }

        memo.put(target, countTimes);
        return countTimes;
    }
}
