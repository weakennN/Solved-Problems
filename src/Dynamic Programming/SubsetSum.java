import java.util.*;

public class SubsetSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int target = Integer.parseInt(scan.nextLine());

        HashMap<Integer, Integer> possibleSum = new HashMap<>();
        possibleSum.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> newSum = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : possibleSum.entrySet()) {
                int sum = entry.getKey() + nums[i];
                if (!possibleSum.containsKey(sum)) {
                    newSum.put(sum, nums[i]);
                }
            }
            for (Map.Entry<Integer, Integer> entry : newSum.entrySet()) {
                possibleSum.put(entry.getKey(), entry.getValue());
            }
        }

        int num = possibleSum.get(target);
        while (num != 0) {
            System.out.print(num + " ");
            target -= num;
            num = possibleSum.get(target);
        }

    }
}
