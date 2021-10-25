package DynamicProgramming;

import java.util.HashMap;

public class GridTraveler {

    public static void main(String[] args) {
        HashMap<String, Long> memo = new HashMap<>();
        System.out.println(gridTravel(18, 18, memo));
    }

    private static long gridTravel(int row, int col, HashMap<String, Long> memo) {
        String memoKey = row + " " + col;
        if (row <= 1 && col <= 1) {
            return 1;
        } else if (row <= 0 || col <= 0) {
            return 0;
        }

        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        memo.put(memoKey, gridTravel(row, col - 1, memo) + gridTravel(row - 1, col, memo));

        return memo.get(memoKey);
    }
}
