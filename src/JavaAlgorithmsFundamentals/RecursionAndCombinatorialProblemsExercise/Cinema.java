package JavaAlgorithmsFundamentals.RecursionAndCombinatorialProblemsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cinema {

    public static String[] friends;
    public static String[] comb;
    public static boolean[] used;
    public static List<String> input;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        input = Arrays.stream(scan.nextLine().split("[, ]+")).collect(Collectors.toList());
        friends = new String[input.size()];

        String com = scan.nextLine();

        while (!com.equals("generate")) {

            String[] people = com.split(" - ");
            int index = Integer.parseInt(people[1]);

            friends[index - 1] = people[0];
            input.remove(people[0]);

            com = scan.nextLine();
        }

        used = new boolean[input.size()];
        comb = new String[input.size()];

        solution(0);
    }


    public static void solution(int index) {

        if (index == comb.length) {

            print();
            return;
        }


        for (int i = 0; i < input.size(); i++) {

            if (!used[i]) {
                used[i] = true;
                comb[index] = input.get(i);
                solution(index + 1);
                used[i] = false;
            }
        }

    }

    public static void print() {

        int index = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < friends.length; i++) {

            if (friends[i] != null) {

                str.append(friends[i] + " ");
            } else {

                str.append(comb[index++] + " ");
            }
        }

        str.replace(str.lastIndexOf(" "), str.length(), "");
        System.out.println(str);
    }
}
