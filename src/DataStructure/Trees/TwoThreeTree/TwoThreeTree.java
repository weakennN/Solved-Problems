package DataStructure.Trees.TwoThreeTree;

public class TwoThreeTree<E extends Comparable<E>> {

    private Node<E> root;

    public TwoThreeTree(E element) {
        this.root = new Node<>(element);
    }

    public void insert(E element) {
        this.root = this.recursiveInsert(this.root, element);
    }

    public void remove(E element) {
        this.recursiveRemove(this.root, element);
        if (this.root.isEmpty()) {
            this.root = this.root.getLeft();
        }
    }

    public Node<E> search(E element) {
        return this.recursiveSearch(this.root, element);
    }

    private Node<E> recursiveInsert(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        } else if (node.isLeaf() && node.getSecondKey() == null) {
            node.insertKey(element);
            return node;
        } else if (node.isLeaf() && node.getFirstKey() != null
                && node.getSecondKey() != null) {
            return this.rebalance(node, new Node<>(element));
        }

        Node<E> temp;
        if (node.getFirstKey().compareTo(element) > 0) {
            temp = this.recursiveInsert(node.getLeft(), element);
            if (node.getLeft() == temp) {
                node.setLeft(temp);
            } else {
                return this.rebalance(node, temp);
            }
        } else if (node.getFirstKey().compareTo(element) < 0 && node.getSecondKey() == null) {
            temp = this.recursiveInsert(node.getMiddle(), element);
            if (node.getMiddle() == temp) {
                node.setMiddle(temp);
            } else {
                return this.rebalance(node, temp);
            }
        } else if (node.getFirstKey().compareTo(element) < 0 && node.getSecondKey().compareTo(element) > 0) {
            temp = this.recursiveInsert(node.getMiddle(), element);
            if (node.getMiddle() == temp) {
                node.setMiddle(temp);
            } else {
                return this.rebalance(node, temp);
            }
        } else {
            temp = this.recursiveInsert(node.getRight(), element);
            if (node.getRight() == temp) {
                node.setRight(temp);
            } else {
                return this.rebalance(node, temp);
            }
        }

        return node;
    }

    private Node<E> recursiveRemove(Node<E> node, E element) {
        if (node == null) {
            return null;
        } else if (node.getFirstKey().compareTo(element) == 0
                || node.getSecondKey() != null &&
                node.getSecondKey().compareTo(element) == 0) {
            if (node.isLeaf()) {
                node.removeElement(element);
            } else {
                Node<E> temp;
                if (node.getFirstKey().compareTo(element) == 0) {
                    Node<E> inorderPredecessor = this.getInorderPredecessor(node);
                    E replace = this.getSuccessorElement(inorderPredecessor);
                    node.setFirstKey(replace);
                    temp = this.recursiveRemove(node.getLeft(), replace);
                } else {
                    Node<E> inorderSuccessor = this.getInorderSuccessor(node);
                    E replace = this.getSuccessorElement(inorderSuccessor);
                    node.setSecondKey(replace);
                    temp = this.recursiveRemove(node.getMiddle(), replace);
                }

                if (temp.isEmpty()) {
                    if (!this.borrow(node, temp, element)) {
                        this.merge(node, temp);
                    }
                }
            }

            return node;
        }

        Node<E> temp;
        if (node.getFirstKey().compareTo(element) > 0) {
            temp = this.recursiveRemove(node.getLeft(), element);
        } else if (node.getFirstKey().compareTo(element) < 0 && node.getSecondKey() == null) {
            temp = this.recursiveRemove(node.getMiddle(), element);
        } else if (node.getFirstKey().compareTo(element) < 0 && node.getSecondKey().compareTo(element) > 0) {
            temp = this.recursiveRemove(node.getMiddle(), element);
        } else {
            temp = this.recursiveRemove(node.getRight(), element);
        }

        if (temp != null) {
            if (temp.isEmpty()) {
                if (!this.borrow(node, temp, element)) {
                    this.merge(node, temp);
                }
            }
        }

        return node;
    }

    private Node<E> rebalance(Node<E> first, Node<E> second) {
        if (first.getSecondKey() == null) {
            if (first.getFirstKey().compareTo(second.getFirstKey()) > 0) {
                first.insertKey(second.getFirstKey());
                first.setLeft(second.getLeft());
                first.setRight(first.getMiddle());
                first.setMiddle(second.getMiddle());
            } else {
                first.insertKey(second.getFirstKey());
                first.setMiddle(second.getLeft());
                first.setRight(second.getMiddle());
            }

            return first;
        }
        if (first.getFirstKey().compareTo(second.getFirstKey()) > 0
                && first.getSecondKey().compareTo(second.getFirstKey()) > 0) {
            Node<E> promoted = new Node<>(first.getFirstKey());
            promoted.setLeft(second);
            Node<E> demoted = new Node<>(first.getSecondKey());
            demoted.setLeft(first.getMiddle());
            demoted.setMiddle(first.getRight());
            promoted.setMiddle(demoted);
            return promoted;
        } else if (first.getFirstKey().compareTo(second.getFirstKey()) < 0
                && first.getSecondKey().compareTo(second.getFirstKey()) < 0) {
            Node<E> promoted = new Node<>(first.getSecondKey());
            promoted.setMiddle(second);
            Node<E> demoted = new Node<>(first.getFirstKey());
            demoted.setLeft(first.getLeft());
            demoted.setMiddle(first.getMiddle());
            promoted.setLeft(demoted);

            return promoted;
        } else {
            Node<E> promoted = new Node<>(second.getFirstKey());
            Node<E> left = new Node<>(first.getFirstKey());
            left.setLeft(first.getLeft());
            left.setMiddle(second.getLeft());
            promoted.setLeft(left);
            Node<E> middle = new Node<>(first.getSecondKey());
            middle.setLeft(second.getMiddle());
            middle.setMiddle(first.getRight());
            promoted.setMiddle(middle);

            return promoted;
        }
    }

    public boolean borrow(Node<E> first, Node<E> second, E deletedElement) {
        if (first.getSecondKey() != null
                && first.getSecondKey().compareTo(deletedElement) < 0) {
            // try to borrow from mid for right
            if (first.getMiddle().getSecondKey() == null) {
                return false;
            }

            E promoted = first.getMiddle().getSecondKey();
            first.getMiddle().setSecondKey(null);
            second.setFirstKey(first.getSecondKey());
            first.setSecondKey(promoted);

            Node<E> replace = first.getMiddle().getRight();
            first.getMiddle().setRight(null);
            second.setMiddle(second.getLeft());
            second.setLeft(replace);

            return true;
        } else if (first.getFirstKey().compareTo(deletedElement) > 0) {
            // try to borrow from mid for left
            if (first.getMiddle().getSecondKey() == null) {
                return false;
            }

            E promoted = first.getMiddle().getFirstKey();
            first.getMiddle().removeElement(first.getMiddle().getFirstKey());
            second.setFirstKey(first.getFirstKey());
            first.setFirstKey(promoted);

            Node<E> replace = first.getMiddle().getLeft();
            first.getMiddle().setLeft(first.getMiddle().getMiddle());
            first.getMiddle().setMiddle(first.getMiddle().getRight());
            first.getMiddle().setRight(null);
            second.setMiddle(replace);

            return true;
        } else {
            // try to borrow from left or right for mid
            if (first.getSecondKey() != null && first.getRight().getSecondKey() != null && first.getMiddle() == second) {
                // borrow from right
                E promoted = first.getRight().getFirstKey();
                first.getRight().removeElement(first.getRight().getFirstKey());
                second.setFirstKey(first.getSecondKey());
                first.setSecondKey(promoted);
                Node<E> replace = first.getRight().getLeft();
                first.getRight().setLeft(first.getRight().getMiddle());
                first.getRight().setMiddle(first.getRight().getRight());
                first.getRight().setRight(null);
                second.setMiddle(replace);

                return true;
            } else if (first.getLeft().getSecondKey() != null && first.getMiddle() == second) {
                // borrow from left
                E promoted = first.getLeft().getSecondKey();
                first.getLeft().setSecondKey(null);
                second.setFirstKey(first.getFirstKey());
                first.setFirstKey(promoted);

                Node<E> replace = first.getLeft().getRight();
                first.getLeft().setRight(null);
                first.getMiddle().setMiddle(first.getMiddle().getLeft());
                first.getMiddle().setLeft(replace);

                return true;
            }
        }

        return false;
    }

    private void merge(Node<E> first, Node<E> second) {
        if (first.getRight() == second) {
            first.setRight(null);
            E demoted = first.getSecondKey();
            first.setSecondKey(null);
            first.getMiddle().insertKey(demoted);
            if (!second.isLeaf()) {
                first.getMiddle().setRight(second.getLeft());
            }
        } else if (first.getLeft() == second) {
            E demoted = first.getFirstKey();
            if (first.getSecondKey() != null) {
                first.removeElement(first.getFirstKey());
                first.getMiddle().insertKey(demoted);
                first.setLeft(first.getMiddle());
                first.setMiddle(first.getRight());
                first.setRight(null);
                if (!second.isLeaf()) {
                    first.getLeft().setRight(first.getLeft().getMiddle());
                    first.getLeft().setMiddle(first.getLeft().getLeft());
                    first.getLeft().setLeft(second.getLeft());
                }
            } else {
                if (!second.isLeaf()) {
                    first.setFirstKey(null);
                    second.insertKey(demoted);
                    second.insertKey(first.getMiddle().getFirstKey());
                    second.setMiddle(first.getMiddle().getLeft());
                    second.setRight(first.getMiddle().getMiddle());
                    first.setMiddle(null);
                } else {
                    first.setFirstKey(null);
                    first.setLeft(first.getMiddle());
                    first.setMiddle(null);
                    first.getLeft().insertKey(demoted);
                }
            }
        } else {
            E demoted = first.getFirstKey();
            first.getLeft().insertKey(demoted);
            first.removeElement(first.getFirstKey());
            first.setMiddle(first.getRight());
            first.setRight(null);
            if (!second.isLeaf()) {
                first.getLeft().setRight(second.getLeft());
            }
        }
    }

    private Node<E> recursiveSearch(Node<E> node, E element) {
        if (node == null) {
            return null;
        } else if (node.getFirstKey().compareTo(element) == 0
                || node.getSecondKey() != null
                && node.getSecondKey().compareTo(element) == 0) {
            return node;
        }

        if (node.getFirstKey().compareTo(element) > 0) {
            return this.recursiveSearch(node.getLeft(), element);
        } else if (node.getFirstKey().compareTo(element) < 0 && node.getSecondKey() == null) {
            return this.recursiveSearch(node.getMiddle(), element);
        } else if (node.getFirstKey().compareTo(element) < 0
                && node.getSecondKey().compareTo(element) > 0) {
            return this.recursiveSearch(node.getMiddle(), element);
        }

        return this.recursiveSearch(node.getRight(), element);
    }

    public Node<E> getInorderPredecessor(Node<E> node) {
        Node<E> current = node.getLeft();

        while (current.getMiddle() != null) {
            if (current.getRight() != null) {
                current = current.getRight();
            } else {
                current = current.getMiddle();
            }
        }

        return current;
    }

    public Node<E> getInorderSuccessor(Node<E> node) {
        Node<E> current = node.getMiddle();

        while (current.getMiddle() != null) {
            if (current.getRight() != null) {
                current = current.getRight();
            } else {
                current = current.getMiddle();
            }
        }

        return current;
    }

    private E getSuccessorElement(Node<E> successor) {
        if (successor.getSecondKey() != null) {
            return successor.getSecondKey();
        }

        return successor.getFirstKey();
    }

    public Node<E> getRoot() {
        return this.root;
    }
}
