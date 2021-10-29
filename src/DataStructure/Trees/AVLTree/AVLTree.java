package DataStructure.Trees.AVLTree;

public class AVLTree<E extends Comparable<E>> {

    private Node<E> root;

    public AVLTree(E element) {
        this.root = new Node<>(element);
    }

    public void insert(E element) {
        this.root = this.recursiveInsert(this.root, element);
    }

    public void remove(E element) {
        this.root = this.recursiveRemove(this.root, element);
        this.root = this.balance(this.root);
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

    private Node<E> recursiveRemove(Node<E> node, E element) {
        if (node == null) {
            return null;
        } else if (node.getElement().compareTo(element) == 0) {
            if (node.getRight() == null && node.getLeft() == null) {
                return null;
            } else {
                Node<E> replace = this.getInorderSuccessor(node);
                if (replace == null) {
                    replace = this.getInorderPredecessor(node);
                }

                this.recursiveRemove(node, replace.getElement());
                replace.setLeft(node.getLeft());
                replace.setRight(node.getRight());

                return replace;
            }
        }

        if (node.getElement().compareTo(element) > 0) {
            node.setLeft(this.recursiveRemove(node.getLeft(), element));
        } else if (node.getElement().compareTo(element) < 0) {
            node.setRight(this.recursiveRemove(node.getRight(), element));
        }

        int balanceFactor = this.calculateHeight(node.getLeft()) - this.calculateHeight(node.getRight());

        if (balanceFactor >= 2) {
            int leftChildBalanceFactor = this.calculateHeight(node.getLeft().getLeft())
                    - this.calculateHeight(node.getLeft().getRight());
            if (leftChildBalanceFactor >= 1) {
                return this.rightRotation(node);
            } else if (leftChildBalanceFactor <= -1) {
                node.setLeft(this.leftRotation(node.getLeft()));
                return this.rightRotation(node);
            } else {
                return this.rightRotation(node);
            }
        } else if (balanceFactor <= -2) {
            int rightChildBalanceFactor = this.calculateHeight(node.getRight().getLeft())
                    - this.calculateHeight(node.getRight().getRight());
            if (rightChildBalanceFactor <= -1) {
                return this.leftRotation(node);
            } else if (rightChildBalanceFactor >= 1) {
                node.setRight(this.rightRotation(node.getRight()));
                return this.leftRotation(node);
            } else {
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

    private Node<E> balance(Node<E> node) {
        if (node == null) {
            return null;
        }

        node.setLeft(balance(node.getLeft()));
        node.setRight(balance(node.getRight()));

        int balanceFactor = this.calculateHeight(node.getLeft()) - this.calculateHeight(node.getRight());

        if (balanceFactor >= 2) {
            int leftChildBalanceFactor = this.calculateHeight(node.getLeft().getLeft())
                    - this.calculateHeight(node.getLeft().getRight());
            if (leftChildBalanceFactor >= 1) {
                return this.rightRotation(node);
            } else if (leftChildBalanceFactor <= -1) {
                node.setLeft(this.leftRotation(node.getLeft()));
                return this.rightRotation(node);
            } else {
                return this.rightRotation(node);
            }
        } else if (balanceFactor <= -2) {
            int rightChildBalanceFactor = this.calculateHeight(node.getRight().getLeft())
                    - this.calculateHeight(node.getRight().getRight());
            if (rightChildBalanceFactor <= -1) {
                return this.leftRotation(node);
            } else if (rightChildBalanceFactor >= 1) {
                node.setRight(this.rightRotation(node.getRight()));
                return this.leftRotation(node);
            } else {
                return this.leftRotation(node);
            }
        }

        return node;
    }
}
