package DataStructure.Trees.RedBlackTree;

public class RedBlackTreeTest {

    public static void main(String[] args) {
       RedBlackTree<Integer> redBlackTree = new RedBlackTree<>(10);
        redBlackTree.insert(20);
        redBlackTree.insert(30);
        redBlackTree.insert(40);

        redBlackTree.remove(10);
        redBlackTree.remove(40);
    }
}
