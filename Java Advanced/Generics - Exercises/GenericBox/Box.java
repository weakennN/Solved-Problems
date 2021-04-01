package Generics.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> items;

    public Box() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        this.items.add(item);

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            str.append(items.get(i).getClass().getName() + ": " + items.get(i) + "\n");
        }

        return str.toString();
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
