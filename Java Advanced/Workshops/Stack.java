package Workshops.ArrayList;

public class Stack<T> {

    private T[] items;
    final static int INITIAL_CAPACITY = 4;
    private int size;
    private int capacity;

    public Stack() {
        Object arr = new Object[INITIAL_CAPACITY];

        this.items = (T[]) arr;

        capacity = INITIAL_CAPACITY;
    }

    public void push(T element) {

        if (this.size + 1 >= this.capacity) {
            resize();
        }

        this.items[size++] = element;

    }

    public T pop() {
        T removed = this.items[this.size - 1];
        this.items[this.size - 1] = null;
        this.size--;

        return removed;
    }

    public T peek() {

        return this.items[size - 1];
    }

    private void resize() {

        this.capacity *= 2;
        Object arr = new Object[capacity];
        T[] copy = (T[]) arr;

        for (int i = 0; i < this.size; i++) {

            copy[i] = this.items[i];
        }

        this.items = copy;
    }

    public int size() {

        return this.size;
    }

    public void forEach() {

        for (int i = 0; i < this.size; i++) {
            System.out.println(this.items[this.size - 1 - i]);
        }

    }

   public boolean isEmpty(){

        return size() <= 0;
   }
}
