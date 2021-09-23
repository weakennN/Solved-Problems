package IteratorsAndComparators.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private int index = 0;
    private List<String> items;

    private class ListIterotor implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < items.size();
        }

        @Override
        public String next() {
            return items.get(index++);
        }
    }

    public ListyIterator(String[] input) {

        this.items = new ArrayList<>();

        for (int i = 1; i < input.length; i++) {
            items.add(input[i]);
        }
    }

    public boolean hasNext() {

        return index + 1 < this.items.size();
    }

    public boolean move() {
        this.index++;
        if (this.index >= this.items.size()) {
            index--;
            return false;
        }
        return true;
    }

    public String print() {

        if (this.items.size() == 0) {
            return "Invalid Operation!";
        }

        return this.items.get(index);
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterotor();
    }


}
