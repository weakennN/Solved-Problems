package Generics.GenericArrayCreator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayCreator<Integer> array = new ArrayCreator<>();

        Integer[] integers = array.create(5, 1);
        Integer[] integerss = array.create(Integer.class,5, 1);
        System.out.println();
    }
}
