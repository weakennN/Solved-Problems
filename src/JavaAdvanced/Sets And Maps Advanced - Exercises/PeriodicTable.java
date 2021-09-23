package SetsAntMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> chemicalCompounds = new TreeSet<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String[] info = scan.nextLine().split("\\s+");

            for (int j = 0; j < info.length; j++) {

                chemicalCompounds.add(info[j]);
            }
        }

        for (String chem : chemicalCompounds){
            System.out.print(chem + " ");
        }
    }
}
