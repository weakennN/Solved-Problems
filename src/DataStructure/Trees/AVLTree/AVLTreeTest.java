package DataStructure.Trees.AVLTree;

public class AVLTreeTest {

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>(501);

        avlTree.insert(169);
        avlTree.insert(254);
        avlTree.insert(897);
        avlTree.insert(379);
        avlTree.insert(300);
        avlTree.insert(691);
        avlTree.insert(944);
        avlTree.insert(669);
        avlTree.insert(668);
        avlTree.insert(510);
        avlTree.insert(939);

        avlTree.remove(46);
        avlTree.remove(86);
        avlTree.remove(88);
        avlTree.remove(61);
        avlTree.remove(89);
        avlTree.remove(78);
        avlTree.remove(54);
        avlTree.remove(83);

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