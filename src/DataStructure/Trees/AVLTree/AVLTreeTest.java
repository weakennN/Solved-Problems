package DataStructure.Trees.AVLTree;

public class AVLTreeTest {

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>(811);
        avlTree.insert(488);
        avlTree.insert(679);
        avlTree.insert(600);

        inorder(avlTree.getRoot());
    }

    private static void inorder(Node<Integer> node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        System.out.print(node.getElement() + " ");
        inorder(node.getRight());
    }

}
