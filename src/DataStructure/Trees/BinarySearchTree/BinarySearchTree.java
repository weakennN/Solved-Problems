package DataStructure.Trees.BinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinarySearchTree(E element) {
        this.root = new Node<>(element);
    }

    public void insert(E element) {
        this.addRecursive(this.root, element);
    }

    public Node<E> search(E element) {
        return recursiveSearch(this.root, element);
    }

    public void remove(E element) {
        this.root = this.recursiveRemove(this.root, element);
    }

    private void addRecursive(Node<E> node, E element) {
        if (node == null) {
            this.root = new Node<>(element);
            return;
        }

        if (node.getElement().compareTo(element) < 0) {
            if (node.getRight() == null) {
                node.setRight(new Node<>(element));
            } else {
                this.addRecursive(node.getRight(), element);
            }
        } else if (node.getElement().compareTo(element) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(element));
            } else {
                this.addRecursive(node.getLeft(), element);
            }
        }
    }

    private Node<E> recursiveSearch(Node<E> node, E element) {
        if (node == null) {
            return null;
        }

        if (node.getElement().compareTo(element) == 0) {
            return node;
        } else if (node.getElement().compareTo(element) > 0) {
            return recursiveSearch(node.getLeft(), element);
        }

        return recursiveSearch(node.getRight(), element);
    }

    private Node<E> recursiveRemove(Node<E> node, E element) {
        if (node == null) {
            return null;
        } else if (node.getElement().compareTo(element) == 0) {
            if (node.getRight() == null
                    && node.getLeft() == null) {
                return null;
            } else {
                Node<E> replace = this.getInorderSuccessor(node);
                if (replace == null) {
                    replace = this.getInorderPredecessor(node);
                }

                this.recursiveRemove(this.root, replace.getElement());
                replace.setRight(node.getRight());
                replace.setLeft(node.getLeft());

                return replace;
            }
        }

        if (node.getElement().compareTo(element) > 0) {
            node.setLeft(this.recursiveRemove(node.getLeft(), element));
        } else {
            node.setRight(this.recursiveRemove(node.getRight(), element));
        }

        return node;
    }

    private Node<E> getInorderSuccessor(Node<E> node) {
        Node<E> current = node.getRight();
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }

    private Node<E> getInorderPredecessor(Node<E> node) {
        Node<E> current = node.getLeft();
        while (current != null && current.getRight() != null) {
            current = current.getRight();
        }

        return current;
    }

    public Node<E> getRoot() {
        return this.root;
    }
}
