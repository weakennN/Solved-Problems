package DataStructure.Trees.RedBlackTree;

public class Node<E extends Comparable<E>> {

    private E element;
    private Node<E> left;
    private Node<E> right;
    private String color;

    public Node(E element) {
        this.element = element;
        this.color = Colors.RED;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
