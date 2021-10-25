package DynamicProgramming;

import java.util.HashMap;

public class CanSum {
    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println(canSum(1000, new int[]{3,1}, new HashMap<>()));
    }

    private static boolean canSum(int totalSum, int[] nums, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(totalSum)) {
            return memo.get(totalSum);
        } else if (totalSum == 0) {
            return true;
        } else if (totalSum < 0) {
            return false;
        }

        System.out.println(++counter);

        for (int i = 0; i < nums.length; i++) {
            memo.put(totalSum, canSum(totalSum - nums[i], nums, memo));
            if (memo.get(totalSum)) {
                return true;
            }
        }

        return false;
    }
}
