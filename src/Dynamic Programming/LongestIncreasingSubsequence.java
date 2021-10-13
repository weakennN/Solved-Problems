import java.util.*;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> longest = new ArrayList<>();
        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> current = longestSubsequence(nums, i, memo);
            if (current.size() > longest.size()) {
                longest = current;
            }
        }

        for (int i = longest.size() - 1; i >= 0; i--) {
            System.out.print(longest.get(i) + " ");
        }
    }
    
    private static List<Integer> longestSubsequence(int[] nums, int index, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(index)) {
            return copy(memo.get(index));
        } else if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[index]);
            memo.put(index, list);
            return list;
        }

        List<Integer> longestSubsequence = new ArrayList<>();
        for (int i = index; i < nums.length - 1; i++) {
            if (nums[index] < nums[i + 1]) {
                List<Integer> sequence = longestSubsequence(nums, i + 1, memo);
                if (longestSubsequence.size() < sequence.size()) {
                    longestSubsequence = sequence;
                }
            }
        }

        longestSubsequence.add(nums[index]);
        memo.put(index, copy(longestSubsequence));
        return longestSubsequence;
    }

    private static List<Integer> copy(List<Integer> copy) {
        return new ArrayList<>(copy);
    }
}
