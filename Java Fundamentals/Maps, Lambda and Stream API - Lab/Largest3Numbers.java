package AssociativeArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted((l, r) -> r.compareTo(l))
                .limit(3)
                .forEach(e -> System.out.print(e + " "));

    }
}

