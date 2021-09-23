package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            int n = Integer.parseInt(line[i]);
            numbers.add(n);
        }

        String[] line1 = scan.nextLine().split(" ");
        List<Integer> numbers1 = new ArrayList<>();

        for (int i = 0; i < line1.length; i++) {
            int n = Integer.parseInt(line1[i]);
            numbers1.add(n);
        }
        List<Integer> result = new ArrayList<>();

        int c = Math.min(numbers.size(), numbers1.size());

        for (int i = 0; i < c; i++) {
            result.add(numbers.get(i));
            result.add(numbers1.get(i));
        }


        if (numbers.size() > numbers1.size()) {
            for (int i = c; i < numbers.size(); i++) {
                result.add(numbers.get(i));
            }
        } else if (numbers1.size() > numbers.size()) {
            for (int i = c; i < numbers1.size(); i++) {
                result.add(numbers1.get(i));
            }
        }
        for (int parts : result) {
            System.out.print(parts + " ");
        }
    }
}
