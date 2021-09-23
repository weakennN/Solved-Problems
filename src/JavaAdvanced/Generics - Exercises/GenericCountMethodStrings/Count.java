package Generics.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Count<T> {

    private List<T> items;

    public Count() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);

    }

    public <T extends Comparable<T>> int compare(T element) {
        int counter = 0;
        for (int i = 0; i < this.items.size(); i++) {

            if (element.compareTo((T) items.get(i)) < 0) {
                counter++;
            }
        }

        return counter;
    }
}
