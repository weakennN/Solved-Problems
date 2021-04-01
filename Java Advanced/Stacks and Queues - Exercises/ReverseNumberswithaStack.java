package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumberswithaStack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] info = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < info.length; i++) {
            numbers.push(info[i]);
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
