package Workshops.ArrayList;

public class SinglyLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {

        private T element;
        private Node<T> next;

        private Node(T element) {
            this.element = element;
        }
    }

    public void add(T element) {

        Node<T> node = new Node<>(element);

        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }

        this.size++;
    }

    public T remove(int index) {

        if (checkIndex(index)) {
            throw new IllegalStateException("exception");
        }

        if (index == this.size - 1 && this.size > 1) {
            return removeLast();
        } else if (index == 0) {
            return removeFirst();
        }

        Node<T> node = find(index);

        T removed = node.next.element;

        node.next = node.next.next;
        this.size--;
        return removed;
    }

    private boolean checkIndex(int index) {

        if (index < 0 || index >= this.size) {
            return true;
        }

        return false;
    }

    public T removeLast() {

        if (this.size == 1) {
            return removeFirst();
        }

        Node<T> current = find(this.size - 1);
        this.tail = current;
        T removed = current.next.element;
        current.next = null;
        this.size--;
        return removed;
    }

    public T removeFirst() {

        if (this.head == null) {
            throw new IllegalStateException("exception");
        }

        Node<T> current = this.head;
        T removed = this.head.element;
        this.head = current.next;
        this.size--;

        if (this.size == 0) {
            this.tail = null;
        }

        return removed;
    }

    private Node<T> find(int index) {

        if (checkIndex(index)) {
            String msg = "ff";
            throw new IndexOutOfBoundsException(msg);
        }

        Node<T> current = this.head;

        while (--index > 0) {

            current = current.next;
        }
        return current;
    }

    public T get(int index) {

        return find(index).element;
    }

    public void reverse() {

        Node<T> reverse = this.head;
        this.head = this.tail;
        this.tail = reverse;

    }

}
