package Workshops.ArrayList;

import java.lang.reflect.Array;

public class ArrayList<E extends Comparable<E>> {

    private E[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;

    public ArrayList() {
        this.data = (E[]) Array.newInstance(String.class, INITIAL_CAPACITY);
        this.capacity = INITIAL_CAPACITY;
    }

    private void resize() {
        this.capacity *= 2;

        E[] copy = (E[]) Array.newInstance(String.class, capacity);

        for (int i = 0; i < data.length; i++) {
            copy[i] = this.data[i];
        }

        this.data = copy;
    }

    public void add(E element) {

        if (this.size + 1 >= this.capacity) {
            resize();
        }

        this.data[size++] = element;
    }

    public E get(int index) {

        checkIndex(index);

        return this.data[index];

    }

    public boolean contains(E element) {

        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(element)) {
                return true;
            }

        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = "Index " + index + " out of bounds for length " + this.size;
            throw new IndexOutOfBoundsException(message);
        }

    }

    public E remove(int index) {

        checkIndex(index);

        if (this.size == this.capacity) {
            resize();
        }

        E removed = this.data[index];

        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }


        this.size--;

        return removed;
    }

    public void forEach() {

        for (int i = 0; i < this.size; i++) {
            System.out.println(this.data[i]);
        }
    }

    public void add(int index, E element) {

        checkIndex(index);

        if (this.size == this.capacity) {
            resize();
        }

        this.size++;

        for (int i = this.size - 1; i > index; i--) {
            E el = this.data[i];
            this.data[i] = this.data[i - 1];
            this.data[i - 1] = el;
        }

        this.data[index] = element;

    }

    public void swap(int index, int indexToSwapWith) {

        checkIndex(index);
        checkIndex(indexToSwapWith);

        E temp = data[index];
        data[index] = data[indexToSwapWith];
        data[indexToSwapWith] = temp;
    }

    public E getMin() {

        E min = this.data[0];
        for (int i = 1; i < this.size; i++) {
            E temp = (E) this.data[i];
            if (min.compareTo(temp) > 0) {
                min = temp;
            }

        }

        return min;
    }

    public E getMax() {

        E max = this.data[0];

        for (int i = 1; i < this.size; i++) {

            E temp = this.data[i];

            if (max.compareTo(temp) < 0) {
                max = temp;
            }

        }

        return max;
    }

    public int compare(E element) {

        int counter = 0;
        for (int i = 0; i < this.size; i++) {

            if (element.compareTo(this.data[i]) < 0) {
                counter++;
            }
        }

        return counter;
    }

    public int countGreaterThan(E element) {
        int counter = 0;
        for (int i = 0; i < this.size; i++) {

            if (element.compareTo(this.data[i]) > 0) {
                counter++;
            }
        }
        return 0;
    }

}
