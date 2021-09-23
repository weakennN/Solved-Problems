package Workshops.ArrayList;

public class SortedArray {

    private int[] data;
    private int size;
    private final static int INITIAL_CAPACITY = 4;
    private int capacity;

    public SortedArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {

        if (this.size + 1 >= this.capacity) {
            resize();
        }

        int index = binarySearch(element);

        shift(index, element);
        this.size++;

    }

    public int binarySearch(int element) {

        if (this.size == 0) {
            return 0;
        }

        if (element <= this.data[0]) {
            return 0;
        } else if (element >= this.data[size - 1]) {
            return this.size;
        }

        int left = 0;
        int right = this.size - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (element >= this.data[mid] && element <= this.data[mid + 1]) {
                return mid + 1;
            } else if (element < this.data[mid]) {
                right = mid - 1;
            } else if (element > this.data[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }

        }

        return -1;
    }

    public void shift(int index, int element) {

        if (index == -1) {
            index = 0;
        }

        for (int i = this.size - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
            this.data[i] = 0;
        }

        this.data[index] = element;
    }

    private void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < data.length; i++) {
            copy[i] = this.data[i];
        }

        this.data = copy;
    }

    public int remove(int index) {

        if (index < 0 || index >= this.size) {
            return -1;
        }

        if (this.size == this.capacity) {
            resize();
        }

        int removed = this.data[index];

        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.size--;

        return removed;
    }

    public void forEach() {

        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    public boolean isSorted() {

        for (int i = 0; i < this.size - 1; i++) {

            if (this.data[i] > this.data[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
