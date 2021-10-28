package JavaFundamentals.ListLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) < 0) {
                numbers.remove(i);
                i = -1;
            }
        }
        int n = numbers.size();
        IfIsEmpty(n);
     /*   if (numbers.size() <= 0) {
            System.out.println("empty");
            return;

        }
     */

        for (int i = 0; i < n / 2; i++) {
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(numbers.size() - i - 1));
            numbers.set(numbers.size() - i - 1, temp);
        }
        for (int parts : numbers) {
            System.out.print(parts + " ");
        }
    }

    public static void IfIsEmpty(int size) {
        if (size <= 0) {
            System.out.print("empty");
        }

    }


}
