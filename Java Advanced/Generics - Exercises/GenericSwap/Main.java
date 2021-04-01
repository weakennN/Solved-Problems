package Generics.GenericSwap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(scan.nextLine());;
            list.add(item);
        }
        String[] input = scan.nextLine().split("\\s+");
        int index1 = Integer.parseInt(input[0]);
        int index2 = Integer.parseInt(input[1]);
        swap(list,index1,index2);
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getClass().getName() + ": " + list.get(i));
        }

    }

    public static <T> void swap(List<T> list, int index1, int index2) {


        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
