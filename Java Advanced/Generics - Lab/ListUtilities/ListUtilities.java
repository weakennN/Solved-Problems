package Generics.ListUtilities;

import java.util.List;

public class ListUtilities {

    public static <T extends Comparable<T>> T getMin(List<T> list) {

        return list.stream().min((l, r) -> l.compareTo(r)).orElseThrow(() -> new IllegalArgumentException());

    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {

        return list.stream().max((l, r) -> l.compareTo(r)).orElseThrow(() -> new IllegalArgumentException());
    }
}
