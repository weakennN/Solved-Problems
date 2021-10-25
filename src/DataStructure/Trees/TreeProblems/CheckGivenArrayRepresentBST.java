package DataStructure.Trees.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class CheckGivenArrayRepresentBST {

    private static int index;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split("[\\s+]"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(doesRepresent(nums, new Node<>(nums[index++]), new ArrayDeque<>()));
    }

    private static boolean doesRepresent(int[] nums,
                                         Node<Integer> node, ArrayDeque<Node<Integer>> parents) {
        if (index >= nums.length) {
            return true;
        }

        if (node.getElement() > nums[index]) {
            node.setLeft(new Node<>(nums[index++]));
            parents.push(node);
            return doesRepresent(nums, node.getLeft(), parents);
        } else if (node.getElement() < nums[index]) {
            if (parents.isEmpty() || parents.peek().getElement() > nums[index]) {
                node.setRight(new Node<>(nums[index++]));
                parents.push(node);
                return doesRepresent(nums, node.getRight(), parents);
            }
        }

        return false;
    }
}
