package Workshops.ArrayList;

public class DoublyLinkedList {

    private int size;
    private Node head;
    private Node tail;

    private static class Node {

        int element;
        Node next;
        Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    public void add(int element) {
        Node node = new Node(element);
        if (this.size == 0) {
            this.head = node;
            this.tail = head;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = this.tail.next;
        }

        this.size++;
    }

    public int remove(int index) {

        checkIndex(index);

        int removed = 0;
        if (index == this.size - 1) {
            if (this.size == 1) {
                removed = this.head.element;
                this.head = null;
                this.tail = null;
                this.size--;
                return removed;
            }
            removed = this.tail.element;
            this.tail = this.tail.prev;
            this.tail.next = null;
            /*
            current.next = null;
            this.tail = current;
            return removed;

             */
            this.size--;
            return removed;
        }

        Node current = find(index - 1);

        removed = current.next.element;
        current.next.next.prev = current;
        current.next = current.next.next;

        this.size--;
        return removed;
    }

    private void checkIndex(int index) {

        if (index < 0 || index >= this.size) {
            String message = "Index " + index + " out of bounds for length " + this.size + ".";
            throw new IndexOutOfBoundsException(message);
        }
    }

    private Node find(int index) {

        checkIndex(index);

        Node current = this.head;

        while (--index >= 0) {

            current = current.next;
        }

        return current;
    }

    public int get(int index) {
        checkIndex(index);

        Node node = find(index);

        return node.element;
    }

    public void reverse() {

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

    }

}
