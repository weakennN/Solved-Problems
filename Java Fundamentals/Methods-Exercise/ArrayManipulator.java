package MethodsLab;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] com = command.split(" ");

            switch (com[0]) {

                case "exchange":
                    int n = Integer.parseInt(com[1]);
                    if (n >= numbers.length || n < 0) {
                        System.out.println("Invalid index");
                    } else {
                        exchange(numbers, n);
                    }
                    break;
                case "max":
                    if (com[1].equals("even")) {
                        max(numbers, 0);
                    } else if (com[1].equals("odd")) {
                        max(numbers, 1);
                    }
                    break;
                case "min":
                    if (com[1].equals("even")) {
                        min(numbers, 0);
                    } else if (com[1].equals("odd")) {
                        min(numbers, 1);
                    }
                    break;
                case "first":
                    n = Integer.parseInt(com[1]);
                    if (isValid(n, numbers)) {
                        if (com[2].equals("even")) {
                            First(numbers, n, 0);
                        } else if (com[2].equals("odd")) {
                            First(numbers, n, 1);
                        }
                    }
                    break;
                case "last":

                    n = Integer.parseInt(com[1]);
                    if (isValid(n, numbers)) {
                        if (com[2].equals("even")) {
                            last(numbers, n, 0);
                            break;
                        } else if (com[2].equals("odd")) {
                            last(numbers, n, 1);
                        }
                    }
                    break;
            }
            command = scan.nextLine();
        }

        printFinalState(numbers, numbers.length);
    }

    public static void exchange(int[] numbers, int index) {
        int[] a = returnTemp(numbers);

        int count = 0;
        for (int i = index + 1; i < numbers.length; i++) {
            numbers[count] = a[i];
            count++;
        }

        for (int i = 0; i <= index; i++) {
            numbers[count] = a[i];
            count++;
        }
    }

    public static int[] returnTemp(int[] num) {
        int[] temp = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            temp[i] = num[i];
        }
        return temp;
    }


    private static void max(int[] numbers, int remainder) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i] % 2) == remainder) {
                if (index == -1 || numbers[i] >= numbers[index])
                    index = i;
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }

    }

    public static void min(int[] numbers, int remainder) {
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i] % 2) == remainder) {
                if (index == -1 || numbers[i] <= numbers[index])
                    index = i;
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static void First(int[] numbers, int count, int remainder) {
        int[] even = new int[count];
        int c = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == remainder) {
                even[c] = numbers[i];
                c++;
                if (c >= count)
                    break;
            }
        }
        printFinalState(even, c);
    }

    public static void last(int[] numbers, int count, int remainder) {
        int[] even = new int[count];
        int c = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == remainder) {
                even[c] = numbers[i];
                c++;
                if (c >= count)
                    break;
            }
        }
        reverse(even, c);
        printFinalState(even, c);
    }

    public static void reverse(int[] nums, int c) {
        int last = c - 1;
        for (int i = last; i >= c / 2; i--) {
            int temp = nums[last - i];
            nums[last - i] = nums[i];
            nums[i] = temp;
        }
    }

    public static void printFinalState(int[] numbers, int c) {
        if (numbers.length == 0 || c == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < c; i++) {
            if (i == c - 1) {
                System.out.print(numbers[i] + "]");
                break;
            }
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();

    }

    public static boolean isValid(int n, int[] numbers) {
        if (n > numbers.length || n < 0) {
            System.out.println("Invalid count");
            return false;
        }
        return true;
    }
}
