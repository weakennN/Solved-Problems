package JavaAlgorithmsFundamentals.RecursionAndCombinatorialProblemsExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TowerOfHanoi {

    public static int steps = 1;
    public static StringBuilder builder = new StringBuilder();
    static ArrayDeque<Integer> source = new ArrayDeque<>();
    static ArrayDeque<Integer> destination = new ArrayDeque<>();
    static ArrayDeque<Integer> spare = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int disk = Integer.parseInt(scan.nextLine());

        for (int i = disk; i > 0; i--) {

            source.push(i);
        }

        printSteps();

        solution(disk, source, destination, spare);
        System.out.println(builder);
    }

    public static void solution(int disk, ArrayDeque<Integer> source,
                                ArrayDeque<Integer> destination, ArrayDeque<Integer> spare) {


        if (disk == 1) {

            destination.push(source.pop());
            builder.append("Step #").append(steps++).
                    append(": Moved disk").append("\n");
            printSteps();
            return;
        }

        solution(disk - 1, source, spare, destination);
        solution(1, source, destination, spare);
        solution(disk - 1, spare, destination, source);

    }

    public static void printSteps() {

        builder.append(String.format("Source: %s%n",
                printStack(source))).
                append(String.format("Destination: %s%n",
                        printStack(destination))).
                append(String.format("Spare: %s%n",
                        printStack(spare))).append("\n");
    }

    public static String printStack(ArrayDeque<Integer> stack) {

        return stack.stream()
                .sorted(Collections.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
