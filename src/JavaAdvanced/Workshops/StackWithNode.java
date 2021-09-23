package Workshops.ArrayList;

public class StackWithNode<T> {

    private int size;
    private Node<T> topNode;

    private static class Node<T> {
        private T element;
        private Node<T> prev;

        private Node(T element) {
            this.element = element;
        }
    }

    public StackWithNode() {

    }

    public void push(int element) {
        Node<T> node = new Node(element);
        if (this.topNode == null) {
            this.topNode = node;
        } else {

            node.prev = this.topNode;
            this.topNode = node;
        }
        this.size++;
    }

    public T peek() {
        isValid();

        return this.topNode.element;
    }

    public T pop() {

        isValid();

        T remove = this.topNode.element;

        this.topNode = this.topNode.prev;
        this.size--;

        return remove;
    }

    private void isValid() {

        if (this.size == 0) {
            String msg = "out of bounds";
            throw new IndexOutOfBoundsException(msg);
        }

    }

    public void forEach() {
        Node<T> currentNode = this.topNode;

        while (currentNode != null) {

            System.out.println(currentNode.element);

            currentNode = currentNode.prev;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {

        return size() <= 0;
    }
}
