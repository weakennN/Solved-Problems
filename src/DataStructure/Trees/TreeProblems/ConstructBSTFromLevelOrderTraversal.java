package DataStructure.Trees.BinarySearchTree;

import java.util.Arrays;
import java.util.Scanner;

public class ConstructBSTFromLevelOrderTraversal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("[\\s+]"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Node<Integer> root = construct(nums);
    }

    private static Node<Integer> construct(int[] nums) {
        Node<Integer> root = null;
        for (int i = 0; i < nums.length; i++) {
            root = constructOrder(root, nums[i]);
        }

        return root;
    }

    private static Node<Integer> constructOrder(Node<Integer> node, int element) {
        if (node == null) {
            return new Node<>(element);
        }

        if (node.getElement() > element) {
            node.setLeft(constructOrder(node.getLeft(), element));
        } else {
            node.setRight(constructOrder(node.getRight(), element));
        }

        return node;
    }
}
