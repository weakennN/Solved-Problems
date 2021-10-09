import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {

    public static void main(String[] args) {
        System.out.println(howSum(8, new int[]{2,3,5}, new HashMap<>()));
    }

    private static ArrayList<Integer> howSum(int targetSum, int[] nums, HashMap<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        } else if (targetSum == 0) {
            return new ArrayList<>();
        } else if (targetSum < 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            memo.put(targetSum, howSum(targetSum - nums[i], nums, memo));
            if (memo.get(targetSum) != null) {
                memo.get(targetSum).add(nums[i]);
                return memo.get(targetSum);
            }
        }

        return null;
    }
}
