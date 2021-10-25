package DataStructure.Trees.BinarySearchTree;

import java.util.Scanner;

public class FindKThSmallestElementInBST {

    private static int k = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(20);
        binarySearchTree.insert(8);
        binarySearchTree.insert(22);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);

        k = Integer.parseInt(scan.nextLine());
        inorder(binarySearchTree.getRoot());
    }

    private static void inorder(Node<Integer> node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        if (--k == 0) {
            System.out.println(node.getElement());
        }
        inorder(node.getRight());
    }
}
