package Generics.ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

       List<String> a = new ArrayList<>();

       a.add("a");
       a.add("b");

        System.out.println(ListUtilities.getMax(a));
    }
}
