import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, memo));
    }

    private static ArrayList<Integer> bestSum(int targetSum, int[] nums, HashMap<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return copy(memo.get(targetSum));
        } else if (targetSum == 0) {
            return new ArrayList<>();
        } else if (targetSum < 0) {
            return null;
        }

        ArrayList<Integer> minPath = null;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> path = bestSum(targetSum - nums[i], nums, memo);
            if (path != null) {
                path.add(nums[i]);
                if (minPath == null || path.size() <= minPath.size()) {
                    minPath = path;
                }
            }
        }

        memo.put(targetSum, minPath);
        return copy(minPath);
    }

    private static ArrayList<Integer> copy(ArrayList<Integer> copyFrom) {
        if (copyFrom == null) {
            return null;
        }

        return new ArrayList<>(copyFrom);
    }
}
