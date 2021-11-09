package DataStructure.Trees.RedBlackTree;

public class RedBlackTree<E extends Comparable<E>> {

    private Node<E> root;

    public RedBlackTree(E element) {
        this.insert(element);
    }

    public void insert(E element) {
        this.root = this.recursiveInsert(this.root, element);
        this.root.setColor(Colors.BLACK);
    }

    public void remove(E element) {
        this.root = this.recursiveRemove(this.root, element);
        if (this.root != null) {
            this.root.setColor(Colors.BLACK);
            if (this.root.getElement() == null) {
                this.root = null;
            }
        }
    }

    private Node<E> recursiveInsert(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        }

        Node<E> temp = null;
        if (node.getElement().compareTo(element) > 0) {
            temp = this.recursiveInsert(node.getLeft(), element);
            node.setLeft(temp);
        } else if (node.getElement().compareTo(element) < 0) {
            temp = this.recursiveInsert(node.getRight(), element);
            node.setRight(temp);
        }

        if (node.getColor().equals(Colors.BLACK)) {
            if (node.getLeft() == temp) {
                if (node.getLeft().getColor().equals(Colors.RED) && node.getLeft().getLeft() != null && node.getLeft().getLeft().getColor().equals(Colors.RED)) {
                    if (!this.recolor(node)) {
                        return this.rightRotation(node);
                    }
                } else if (node.getLeft().getColor().equals(Colors.RED) && node.getLeft().getRight() != null && node.getLeft().getRight().getColor().equals(Colors.RED)) {
                    if (!this.recolor(node)) {
                        return this.leftRight(node);
                    }
                }
            } else {
                if (node.getRight().getColor().equals(Colors.RED) && node.getRight().getRight() != null && node.getRight().getRight().getColor().equals(Colors.RED)) {
                    if (!this.recolor(node)) {
                        return this.leftRotation(node);
                    }
                } else if (node.getRight().getColor().equals(Colors.RED) && node.getRight().getLeft() != null && node.getRight().getLeft().getColor().equals(Colors.RED)) {
                    if (!this.recolor(node)) {
                        return this.rightLeft(node);
                    }
                }
            }
        }

        return node;
    }

    private Node<E> recursiveRemove(Node<E> node, E element) {
        if (node == null) {
            return null;
        } else if (node.getElement().compareTo(element) == 0) {
            if (node.getLeft() == null && node.getRight() == null && node.getColor().equals(Colors.BLACK)) {
                node.setElement(null);
                node.setColor(Colors.DOUBLE_BLACK);
                return node;
            } else if (node.getLeft() == null && node.getRight() == null && node.getColor().equals(Colors.RED)) {
                return null;
            } else if (node.getRight() == null) {
                node.getLeft().setColor(node.getColor());
                return node.getLeft();
            } else if (node.getLeft() == null) {
                node.getRight().setColor(node.getColor());
                return node.getRight();
            } else {
                Node<E> inorderSuccessor = this.getInorderSuccessor(node);
                node.setElement(inorderSuccessor.getElement());
                node.setRight(this.recursiveRemove(node.getRight(), inorderSuccessor.getElement()));
            }
        }

        Node<E> temp;
        if (node.getElement().compareTo(element) > 0) {
            temp = this.recursiveRemove(node.getLeft(), element);
            node.setLeft(temp);
        } else if (node.getElement().compareTo(element) < 0) {
            temp = this.recursiveRemove(node.getRight(), element);
            node.setRight(temp);
        }

        if (node.getLeft() != null && node.getLeft().getColor().equals(Colors.DOUBLE_BLACK)
                || node.getRight() != null && node.getRight().getColor().equals(Colors.DOUBLE_BLACK)) {
            return this.applyCases(node);
        }

        return node;
    }

    private Node<E> applyCases(Node<E> node) {
        if (node.getLeft() != null && node.getLeft().getColor().equals(Colors.DOUBLE_BLACK)) {
            if (node.getRight().getColor().equals(Colors.BLACK)) {
                if (node.getRight().isLeaf() || node.getRight().getRight() != null && node.getRight().getLeft() != null
                        && node.getRight().getRight().getColor().equals(Colors.BLACK) && node.getRight().getLeft().getColor().equals(Colors.BLACK)
                        || node.getRight().getRight() != null && node.getRight().getRight().getColor().equals(Colors.BLACK) && node.getRight().getLeft() == null
                        || node.getRight().getLeft() != null && node.getRight().getLeft().getColor().equals(Colors.BLACK) && node.getRight().getRight() == null) {
                    return this.thirdCase(node);
                } else if (node.getRight().getLeft() != null && node.getRight().getLeft().getColor().equals(Colors.RED)
                        && node.getRight().getRight() == null || node.getRight().getRight().getColor().equals(Colors.BLACK)) {
                    return this.fifthCase(node);
                }
            } else {
                return this.forthCase(node);
            }
        } else {
            if (node.getLeft().getColor().equals(Colors.BLACK)) {
                if (node.getLeft().isLeaf() || node.getLeft().getLeft() != null
                        && node.getLeft().getLeft().getColor().equals(Colors.BLACK) && node.getLeft().getRight() == null
                        || node.getLeft().getRight() != null && node.getLeft().getRight().getColor().equals(Colors.BLACK) && node.getLeft().getLeft() == null
                        || node.getLeft().getLeft() != null && node.getLeft().getRight() != null && node.getLeft().getLeft().getColor().equals(Colors.BLACK)
                        && node.getLeft().getRight().getColor().equals(Colors.BLACK)) {
                    return this.thirdCase(node);
                } else if (node.getLeft().getRight() != null && node.getColor().equals(Colors.RED)
                        && node.getLeft().getLeft() == null || node.getLeft().getLeft().getColor().equals(Colors.BLACK)) {
                    return this.fifthCase(node);
                }
            } else {
                return this.forthCase(node);
            }
        }

        return this.sixthCase(node);
    }

    private boolean recolor(Node<E> node) {
        if (node.getLeft() != null && node.getRight() != null
                && node.getLeft().getColor().equals(Colors.RED)
                && node.getRight().getColor().equals(Colors.RED)) {
            node.setColor(Colors.RED);
            node.getLeft().setColor(Colors.BLACK);
            node.getRight().setColor(Colors.BLACK);

            return true;
        }

        return false;
    }

    private Node<E> rightRotation(Node<E> node) {
        Node<E> newRoot = node.getLeft();
        Node<E> newRootRight = newRoot.getRight();

        node.setLeft(newRootRight);
        newRoot.setRight(node);

        newRoot.setColor(Colors.BLACK);
        newRoot.getRight().setColor(Colors.RED);

        return newRoot;
    }

    private Node<E> leftRotation(Node<E> node) {
        Node<E> newRoot = node.getRight();
        Node<E> newRootLeft = newRoot.getLeft();

        node.setRight(newRootLeft);
        newRoot.setLeft(node);

        newRoot.setColor(Colors.BLACK);
        newRoot.getLeft().setColor(Colors.RED);

        return newRoot;
    }

    private Node<E> leftRight(Node<E> node) {
        Node<E> root = node.getLeft().getRight();
        Node<E> rootLeft = root.getLeft();
        Node<E> rootRight = root.getRight();

        root.setLeft(node.getLeft());
        root.getLeft().setRight(rootLeft);
        node.setLeft(rootRight);
        root.setRight(node);

        root.setColor(Colors.BLACK);
        root.getRight().setColor(Colors.RED);

        return root;
    }

    private Node<E> rightLeft(Node<E> node) {
        Node<E> root = node.getRight().getLeft();
        Node<E> rootLeft = root.getLeft();
        Node<E> rootRight = root.getRight();

        node.getRight().setLeft(rootRight);
        root.setRight(node.getRight());
        node.setRight(rootLeft);
        root.setLeft(node);

        root.setColor(Colors.BLACK);
        root.getLeft().setColor(Colors.RED);

        return root;
    }

    private Node<E> thirdCase(Node<E> node) {
        if (node.getLeft() != null && node.getLeft().getColor().equals(Colors.DOUBLE_BLACK)) {
            node.getRight().setColor(Colors.RED);
            if (node.getLeft().getElement() == null) {
                node.setLeft(null);
            } else {
                node.getLeft().setColor(Colors.BLACK);
            }

        } else {
            node.getLeft().setColor(Colors.RED);
            if (node.getRight().getElement() == null) {
                node.setRight(null);
            } else {
                node.getRight().setColor(Colors.BLACK);
            }
        }

        if (node.getColor().equals(Colors.BLACK)) {
            node.setColor(Colors.DOUBLE_BLACK);
        } else {
            node.setColor(Colors.BLACK);
        }

        return node;
    }

    private Node<E> forthCase(Node<E> node) {
        Node<E> temp;
        node.setColor(Colors.RED);

        if (node.getLeft().getColor().equals(Colors.DOUBLE_BLACK)) {
            node.getRight().setColor(Colors.BLACK);
            temp = this.leftRotation(node);
            temp.setLeft(this.applyCases(temp.getLeft()));
        } else {
            node.getLeft().setColor(Colors.BLACK);
            temp = this.rightRotation(node);
            temp.setRight(this.applyCases(temp.getRight()));
        }

        return temp;
    }

    private Node<E> fifthCase(Node<E> node) {
        node.setColor(Colors.RED);

        if (node.getLeft().getColor().equals(Colors.DOUBLE_BLACK)) {
            node.getRight().getLeft().setColor(Colors.BLACK);
            node.setRight(this.rightRotation(node.getRight()));
        } else {
            node.getLeft().getRight().setColor(Colors.BLACK);
            node.setLeft(this.leftRotation(node.getLeft()));
        }

        return this.sixthCase(node);
    }

    private Node<E> sixthCase(Node<E> node) {
        Node<E> temp;
        String nodeColor = node.getColor();
        if (node.getRight().getColor().equals(Colors.DOUBLE_BLACK)) {
            node.setColor(node.getLeft().getColor());
            node.getLeft().setColor(nodeColor);
            node.getRight().setColor(Colors.BLACK);
            node.getLeft().getLeft().setColor(Colors.BLACK);
            if (node.getRight().getElement() == null) {
                node.setRight(null);
            }
            temp = this.rightRotation(node);
            temp.getRight().setColor(Colors.BLACK);
        } else {
            node.setColor(node.getRight().getColor());
            node.getRight().setColor(nodeColor);
            node.getLeft().setColor(Colors.BLACK);
            node.getRight().getRight().setColor(Colors.BLACK);
            if (node.getLeft().getElement() == null) {
                node.setLeft(null);
            }
            temp = this.leftRotation(node);
            temp.getLeft().setColor(Colors.BLACK);
        }

        return temp;
    }

    private Node<E> getInorderSuccessor(Node<E> node) {
        Node<E> current = node.getRight();
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }
}
