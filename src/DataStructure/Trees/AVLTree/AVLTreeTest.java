package DataStructure.Trees.AVLTree;

public class AVLTreeTest {

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>(14);
        avlTree.insert(11);
        avlTree.insert(19);
        avlTree.insert(7);
        avlTree.insert(12);
        avlTree.insert(17);
        avlTree.insert(53);
        avlTree.insert(13);
        avlTree.insert(4);
        avlTree.insert(8);
        avlTree.insert(16);
        avlTree.insert(20);
        avlTree.insert(60);

        avlTree.remove(8);
        inorder(avlTree.getRoot());
        System.out.println();
        avlTree.remove(7);
        inorder(avlTree.getRoot());
        System.out.println();
        avlTree.remove(11);
        inorder(avlTree.getRoot());
        System.out.println();
        avlTree.remove(14);
        inorder(avlTree.getRoot());
        System.out.println();
        avlTree.remove(17);
        inorder(avlTree.getRoot());
        System.out.println();
    }

    private static void inorder(Node<Integer> node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        System.out.print(node.getElement() + " ");
        inorder(node.getRight());
    }

    private static void preorder(Node<Integer> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getElement());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

}
