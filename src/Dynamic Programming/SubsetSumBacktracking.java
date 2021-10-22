import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsetSumBacktracking {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("[\\s+]"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetSum = Integer.parseInt(scan.nextLine());

        int totalSum = Arrays.stream(nums).sum();

        System.out.println(subsetSum(nums, totalSum, 0, targetSum, 0));
    }

    private static List<Integer> subsetSum(int[] nums, int leftSum, int rightSum, int targetSum, int index) {
        if (rightSum == targetSum) {
            return new ArrayList<>();
        } else if (index >= nums.length || leftSum < 0) {
            return null;
        }

        List<Integer> include = subsetSum(nums, leftSum - nums[index], rightSum + nums[index], targetSum, index + 1);
        List<Integer> notInclude = subsetSum(nums, leftSum, rightSum, targetSum, index + 1);

        if (include != null) {
            include.add(nums[index]);
            return include;
        }

        return notInclude;
    }
}
