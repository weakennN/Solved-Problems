package DataStructure.Trees.BinarySearchTree;

public class CheckIfBinaryTreeContainsDeadNode {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(8);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(2);
        binarySearchTree.insert(13);
        binarySearchTree.insert(9);

        System.out.println(checkDeadEnd(binarySearchTree.getRoot(), 1, Integer.MAX_VALUE));
    }

    public static boolean checkDeadEnd(Node<Integer> root, int min, int max) {
           if (root == null)
            return false;

        if (min == max)
            return true;

        return checkDeadEnd(root.getLeft(), min, root.getElement() - 1) ||
                checkDeadEnd(root.getRight(), root.getElement() + 1, max);
    }
}
