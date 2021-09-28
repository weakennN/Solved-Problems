package DataStructure.Trees.BinaryTree;

public class Node<E extends Comparable<E>> {

    private E element;
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;

    public Node(E element) {
        this.element = element;
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

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getParent() {
        return this.parent;
    }
}
