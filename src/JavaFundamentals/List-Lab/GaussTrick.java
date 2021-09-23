package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            int n = Integer.parseInt(line[i]);
            numbers.add(n);
        }
        int lenght = numbers.size();
        for (int i = 0; i < lenght / 2; i++) {

            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }
        for (int parts : numbers){
            System.out.print(parts + " ");
        }
    }
}
