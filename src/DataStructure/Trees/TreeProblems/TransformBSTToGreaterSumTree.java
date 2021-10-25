package DataStructure.Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class TransformBSTToGreaterSumTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>(9);
        binaryTree.insert(5);
        binaryTree.insert(11);
        binaryTree.insert(10);
        binaryTree.insert(13);

        List<Integer> sums = getAllSums(binaryTree.getRoot(), binaryTree);
        transform(binaryTree.getRoot(), sums);
    }

    private static List<Integer> getAllSums(Node<Integer> node, BinarySearchTree<Integer> binarySearchTree) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<Integer> left = getAllSums(node.getLeft(), binarySearchTree);
        List<Integer> right = getAllSums(node.getRight(), binarySearchTree);
        left.add(getGreaterSum(binarySearchTree.getRoot(), node.getElement()));
        left.addAll(right);
        return left;
    }

    private static void transform(Node<Integer> node, List<Integer> sums) {
        if (node == null) {
            return;
        }

        transform(node.getLeft(), sums);
        node.setElement(sums.remove(0));
        transform(node.getRight(), sums);
    }

    private static int getGreaterSum(Node<Integer> node, int element) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        sum += getGreaterSum(node.getLeft(), element);
        sum += getGreaterSum(node.getRight(), element);
        if (node.getElement() > element) {
            sum += node.getElement();
        }

        return sum;
    }
}
