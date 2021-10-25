package DynamicProgramming;

public class FrogRiverProblem {

    public static void main(String[] args) {
        System.out.println(frogRiver(2, new int[]{1, 2}));
    }

    private static int frogRiver(int destination, int[] nums) {
        if (destination == 0) {
            return 1;
        } else if (destination < 0) {
            return 0;
        }

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += frogRiver(destination - nums[i], nums);
        }

        return total;
    }
}
