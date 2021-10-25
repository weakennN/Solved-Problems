package DataStructure.Trees.TreeProblems;


import DataStructure.Trees.BinarySearchTree.Node;

import java.util.ArrayDeque;

public class InvertBinaryTree {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.setLeft(new Node<>(2));
        root.setRight(new Node<>(3));
        root.getRight().setLeft(new Node<>(4));
        root.getRight().setRight(new Node<>(5));
        root = invertRecursive(root);
    }

    private static Node<Integer> invertRecursive(Node<Integer> node) {
        if (node == null) {
            return null;
        }

        Node<Integer> left = invertRecursive(node.getLeft());
        Node<Integer> right = invertRecursive(node.getRight());

        node.setLeft(right);
        node.setRight(left);

        return node;
    }

    private static void invertIterative(Node<Integer> node) {
        if (node == null) {
            return;
        }

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();

            Node<Integer> temp = current.getLeft();
            current.setLeft(current.getRight());
            current.setRight(temp);

            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }
    }
}
