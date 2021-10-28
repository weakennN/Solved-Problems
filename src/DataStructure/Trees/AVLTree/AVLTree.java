package DataStructure.Trees.AVLTree;

public class AVLTree<E extends Comparable<E>> {

    private Node<E> root;

    public AVLTree(E element) {
        this.root = new Node<>(element);
    }

    public void insert(E element) {
        this.root = this.recursiveInsert(this.root, element);
    }

    private Node<E> recursiveInsert(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        }

        if (node.getElement().compareTo(element) > 0) {
            node.setLeft(this.recursiveInsert(node.getLeft(), element));
        } else if (node.getElement().compareTo(element) < 0) {
            node.setRight(this.recursiveInsert(node.getRight(), element));
        }

        int balanceFactor = calculateHeight(node.getLeft()) - calculateHeight(node.getRight());

        if (balanceFactor >= 2) {
            if (node.getLeft().getElement().compareTo(element) > 0) {
                return this.rightRotation(node);
            } else {
                node.setLeft(this.leftRotation(node.getLeft()));
                return this.rightRotation(node);
            }
        } else if (balanceFactor <= -2) {
            if (node.getRight().getElement().compareTo(element) < 0) {
                return this.leftRotation(node);
            } else {
                node.setRight(this.rightRotation(node.getRight()));
                return this.leftRotation(node);
            }
        }

        return node;
    }

    private Node<E> leftRotation(Node<E> node) {
        Node<E> newRoot = node.getRight();
        Node<E> newRootLeft = newRoot.getLeft();

        node.setRight(newRootLeft);
        newRoot.setLeft(node);

        return newRoot;
    }

    private Node<E> rightRotation(Node<E> node) {
        Node<E> newRoot = node.getLeft();
        Node<E> newRootRight = newRoot.getRight();

        node.setLeft(newRootRight);
        newRoot.setRight(node);

        return newRoot;
    }

    private int calculateHeight(Node<E> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight()));
    }

    public Node<E> getRoot() {
        return this.root;
    }
}
