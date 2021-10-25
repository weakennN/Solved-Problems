package DynamicProgramming;

import java.util.*;

public class MoveDownRightRecursive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        HashMap<String, List<int[]>> memo = new HashMap<>();
        print(sum(matrix, 0, 0, memo));
    }

    private static List<int[]> sum(int[][] matrix, int row, int col, HashMap<String, List<int[]>> memo) {
        String key = row + " " + col;
        if (memo.containsKey(key)) {
            return copy(memo.get(key));
        } else if (row >= matrix.length || col >= matrix[0].length) {
            return new ArrayList<>();
        }

        List<int[]> firstPath = sum(matrix, row + 1, col, memo);
        List<int[]> secondPath = sum(matrix, row, col + 1, memo);

        List<int[]> max = compere(matrix, firstPath, secondPath);
        max.add(new int[]{row, col});
        memo.put(key, copy(max));
        return max;
    }

    private static List<int[]> compere(int[][] matrix, List<int[]> first, List<int[]> second) {
        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < first.size(); i++) {
            firstSum += matrix[first.get(i)[0]][first.get(i)[1]];
        }
        for (int i = 0; i < second.size(); i++) {
            secondSum += matrix[second.get(i)[0]][second.get(i)[1]];
        }

        if (firstSum >= secondSum) {
            return first;
        }

        return second;
    }

    private static void print(List<int[]> path) {
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(Arrays.toString(path.get(i)) + " ");
        }
    }

    private static List<int[]> copy(List<int[]> copyFrom) {
        return new ArrayList<>(copyFrom);
    }
}
