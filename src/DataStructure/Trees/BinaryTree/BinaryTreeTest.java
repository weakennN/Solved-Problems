package DataStructure.Trees.BinaryTree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(100);
        binaryTree.add(90);
        binaryTree.add(130);
        binaryTree.add(80);
        binaryTree.add(95);
        binaryTree.add(125);
        binaryTree.add(135);
        binaryTree.postorder();
    }
}
