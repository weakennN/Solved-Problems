package Generics.GenericCountMethodStrings;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Count<Double> list = addToList(scan);

        double compare = Double.parseDouble(scan.nextLine());

        System.out.println(list.compare(compare));


    }

    public static Count<Double> addToList(Scanner scan) {

        int n = Integer.parseInt(scan.nextLine());
        Count<Double> list = new Count<>();

        for (int i = 0; i < n; i++) {
            double command = Double.parseDouble(scan.nextLine());
            list.add(command);
        }
        return list;
    }
}
