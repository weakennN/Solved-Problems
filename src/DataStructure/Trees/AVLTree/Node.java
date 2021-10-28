package DataStructure.Trees.AVLTree;

public class Node<E extends Comparable<E>> {

    private Node<E> left;
    private Node<E> right;
    private E element;

    public Node(E element) {
        this.element = element;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public E getElement() {
        return this.element;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
