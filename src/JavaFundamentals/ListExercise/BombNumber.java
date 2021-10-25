package JavaFundamentals.ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] nums = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int bombInfo = nums[0];
        int power = nums[1];

        while (numbers.contains(bombInfo)) {

            int index = numbers.indexOf(bombInfo);

            int leftBound = Math.max(index - power, 0);
            int rightBound = Math.min(index + power, numbers.size() - 1);

            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
        }

        int sum = 0;

        for (int parts : numbers) {
            sum += parts;
        }
        System.out.println(sum);
    }
}
