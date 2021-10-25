package JavaAlgorithmsFundamentals.RecursionAndCombinatorialProblemsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams {

    public static String[] girls;
    public static String[] boys;
    public static String[] combinationWithBoys = new String[2];
    public static String[] combinationWithGirls = new String[3];
    public static List<String> allGirls = new ArrayList<>();
    public static List<String> allBoys = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        girls = scan.nextLine().split(", +");
        boys = scan.nextLine().split(", +");

        combWithGirls(0, 0);
        combWithBoys(0, 0);

        for (String girls : allGirls) {

            for (String boys : allBoys) {

                System.out.println(girls + ", " + boys);
            }
        }

    }

    public static void combWithBoys(int index, int start) {

        if (index >= combinationWithBoys.length) {

            allBoys.add(String.join(", ", combinationWithBoys));
            return;
        }

        for (int i = start; i < boys.length; i++) {

            combinationWithBoys[index] = boys[i];
            combWithBoys(index + 1, i + 1);
        }
    }

    public static void combWithGirls(int index, int start) {

        if (index >= combinationWithGirls.length) {

            allGirls.add(String.join(", ", combinationWithGirls));
            return;
        }

        for (int i = start; i < girls.length; i++) {

            combinationWithGirls[index] = girls[i];
            combWithGirls(index + 1, i + 1);
        }
    }
}
