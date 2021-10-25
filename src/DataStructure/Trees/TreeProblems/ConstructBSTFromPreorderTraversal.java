package DataStructure.Trees.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ConstructBSTFromPreorderTraversal {

    private static int index = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("[\\s+]"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Node<Integer> root = new Node<>(nums[index++]);
        constructBTSFromPreorder(nums, root, new ArrayDeque<>());
    }

    private static void constructBTSFromPreorder(int[] nums, Node<Integer> node, ArrayDeque<Node<Integer>> prevs) {
        if (index >= nums.length) {
            return;
        }

        if (node.getElement() > nums[index]) {
            node.setLeft(new Node<>(nums[index++]));
            prevs.push(node);
            constructBTSFromPreorder(nums, node.getLeft(), prevs);
            prevs.pop();
        }

        if (node.getElement() < nums[index]) {
            if (prevs.isEmpty() || prevs.peek().getElement() > nums[index]) {
                node.setRight(new Node<>(nums[index++]));
                constructBTSFromPreorder(nums, node.getRight(), prevs);
            }
        }
    }
}
