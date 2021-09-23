package IteratorsAndComparators.Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private int i;
    private List<Integer> list;

    private class Frog implements Iterator<Integer> {
        private int index = 0;
        private int finalIndex = list.size() % 2 == 0 ? list.size() - 2 : list.size() - 1;

        @Override
        public boolean hasNext() {
            return this.index < list.size();
        }

        @Override
        public Integer next() {

            int indx = index;
            index += 2;

            if (indx == finalIndex) {
                index = 1;

                return list.get(indx);
            }


            return list.get(indx);
        }
    }

    public Lake(int[] numbers) {

        this.list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            this.list.add(numbers[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Frog();
    }
}
