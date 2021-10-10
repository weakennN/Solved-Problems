import java.util.HashMap;

public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "eeeee", "eeeeee", "f"}, new HashMap<>()));
    }

    private static boolean canConstruct(String target, String[] words, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        } else if (target.length() <= 0) {
            return true;
        }

        for (int i = 0; i < words.length; i++) {
            if (target.length() >= words[i].length()) {
                if (target.startsWith(words[i])) {
                    if (canConstruct(target.substring(words[i].length()), words, memo)) {
                        // memo.put(target,true);
                        return true;
                    }
                }

            }
        }

        memo.put(target, false);
        return false;
    }
}
