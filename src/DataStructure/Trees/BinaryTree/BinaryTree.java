package DataStructure.Trees.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinaryTree(E element) {
        this.root = new Node<>(element);
    }

    public void add(E element) {
        Node<E> current = this.root;
        Node<E> newNode = new Node<>(element);
        boolean stop = false;

        while (!stop) {
            if (current.getElement().compareTo(element) > 0) {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    newNode.setParent(current);
                    stop = true;
                } else {
                    current = current.getLeft();
                }
            } else {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                    newNode.setParent(current);
                    stop = true;
                } else {
                    current = current.getRight();
                }
            }
        }
    }

    public void remove(E element) {
        ArrayDeque<Node<E>> queue = new ArrayDeque<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();

            if (current.getElement().equals(element)) {
                // remove
                this.removeNode(current);
                return;
            }

            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }
    }

    public void levelOrderTraversal() {
        ArrayDeque<Node<E>> queue = new ArrayDeque<>();
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();

            System.out.println(current.getElement());

            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }
    }

    public void inorder() {
        this.doInorder(this.root);
    }

    public void inorderIterative() {
        Deque<Node<E>> stack = new ArrayDeque<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node<E> current = stack.peek();

        }

    }

    public void postorder() {
        this.doPostorder(this.root);
    }

    private void doPostorder(Node<E> node) {
        if (node == null) {
            return;
        }

        this.doPostorder(node.getLeft());
        this.doPostorder(node.getRight());
        System.out.println(node.getElement());
    }

    private void doInorder(Node<E> node) {
        if (node == null) {
            return;
        }

        this.doInorder(node.getLeft());
        System.out.println(node.getElement());
        this.doInorder(node.getRight());
    }

    public void preorder() {
        this.doPreorder(this.root);
    }

    private void doPreorder(Node<E> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getElement());
        this.doPreorder(node.getLeft());
        this.doPreorder(node.getRight());
    }

    public Node<E> getRoot() {
        return this.root;
    }

    private void removeNode(Node<E> node) {
        if (node.getParent().getLeft() == node) {
            node.getParent().setLeft(null);
        } else {
            node.getParent().setRight(null);
        }
        node.setParent(null);
    }
}
