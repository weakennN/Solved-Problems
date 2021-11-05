package DataStructure.Trees.TwoThreeTree;

public class Node<E extends Comparable<E>> {

    private E firstKey;
    private E secondKey;
    private Node<E> left;
    private Node<E> middle;
    private Node<E> right;

    public Node(E firstKey) {
        this.firstKey = firstKey;
    }

    public E getFirstKey() {
        return firstKey;
    }

    public void setFirstKey(E firstKey) {
        this.firstKey = firstKey;
    }

    public E getSecondKey() {
        return secondKey;
    }

    public void setSecondKey(E secondKey) {
        this.secondKey = secondKey;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getMiddle() {
        return middle;
    }

    public void setMiddle(Node<E> middle) {
        this.middle = middle;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return this.left == null && this.middle == null
                && this.right == null;
    }

    public void insertKey(E element) {
        if (this.firstKey == null) {
            this.firstKey = element;
            return;
        }

        if (this.firstKey.compareTo(element) < 0) {
            this.setSecondKey(element);
        } else {
            E temp = this.firstKey;
            this.setFirstKey(element);
            this.setSecondKey(temp);
        }
    }

    public void removeElement(E element) {
        if (this.firstKey.compareTo(element) == 0) {
            this.firstKey = this.secondKey;
        }
        this.secondKey = null;
    }

    public boolean isEmpty() {
        return this.firstKey == null
                && this.secondKey == null;
    }
}
