package DataStructure.LinearDataStructure.BinaryHeap;

// max heap
public class BinaryHeap {

    private int[] elements;
    private int size;

    public BinaryHeap(int size) {
        this.elements = new int[size];
        this.size = 0;
    }

    public void insert(int element) {
        if (this.size >= this.elements.length) {
            throw new IllegalArgumentException("The heap is full!");
        }

        this.elements[this.size] = element;
        int i = this.size;
        this.size++;

        while (i != 0 && this.elements[(i - 1) / 2] < element) {
            this.elements[i] = this.elements[(i - 1) / 2];
            this.elements[(i - 1) / 2] = element;
            i = (i - 1) / 2;
        }
    }

    public int getSize() {
        return this.size;
    }

    public void remove() {
        if (this.size <= 0) {
            throw new IllegalArgumentException("The heap is empty!");
        }

        this.swap(0, this.size - 1);
        this.size--;
        int i = 0;
        int j = 1;

        while (j < this.size - 1) {
            if (this.elements[j] < this.elements[j + 1]) {
                j += 1;
            }
            if (this.elements[i] < this.elements[j]) {
                this.swap(i, j);
                i = j;
                j = i * 2 + 1;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = temp;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }
}
