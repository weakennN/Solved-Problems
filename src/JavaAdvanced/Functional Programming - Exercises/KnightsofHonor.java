package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class KnightsofHonor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(e -> System.out.println("Sir " + e));

    }
}
