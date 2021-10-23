package DataStructure.Trees.BinarySearchTree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(11);
        binarySearchTree.insert(7);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(6);

        inorder(binarySearchTree.getRoot());
        System.out.println();
        binarySearchTree.remove(5);
        inorder(binarySearchTree.getRoot());
    }

    private static void inorder(Node<Integer> node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        System.out.println(node.getElement());
        inorder(node.getRight());
    }
}
