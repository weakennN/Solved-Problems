package DataStructure.Trees.TwoThreeTree;

public class TwoThreeTreeTest {

    public static void main(String[] args) {
        testTwo();
    }

    public static void testOne() {
        TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>(20);
        twoThreeTree.insert(30);
        twoThreeTree.insert(40);
        twoThreeTree.insert(50);
        twoThreeTree.insert(60);
        twoThreeTree.insert(10);
        twoThreeTree.insert(15);
        twoThreeTree.insert(70);
        twoThreeTree.insert(80);
        twoThreeTree.insert(90);

        twoThreeTree.remove(60);
        twoThreeTree.remove(20);
        twoThreeTree.remove(50);
        twoThreeTree.remove(40);
        // twoThreeTree.remove(90);
    }

    public static void testTwo() {
        TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>(10);
        twoThreeTree.insert(20);
        twoThreeTree.insert(30);
        twoThreeTree.insert(40);
        twoThreeTree.insert(50);
        twoThreeTree.insert(60);
        twoThreeTree.insert(70);
        twoThreeTree.insert(80);
        twoThreeTree.insert(90);
        twoThreeTree.insert(75);
        twoThreeTree.insert(77);
        twoThreeTree.insert(100);
        twoThreeTree.insert(110);
        twoThreeTree.insert(35);
        twoThreeTree.insert(36);

        twoThreeTree.remove(50);
    }

    public static void testThree() {
        TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>(20);
        twoThreeTree.insert(10);
        twoThreeTree.insert(30);
        twoThreeTree.insert(40);
        twoThreeTree.insert(50);

        twoThreeTree.remove(10);
    }

    public static void testFour() {
        TwoThreeTree<Integer> twoThreeTree = new TwoThreeTree<>(20);
        twoThreeTree.insert(10);
        twoThreeTree.insert(30);
        twoThreeTree.insert(40);
        twoThreeTree.insert(50);
        twoThreeTree.insert(60);
        twoThreeTree.insert(70);
        twoThreeTree.insert(80);
        twoThreeTree.insert(90);
        twoThreeTree.insert(100);
        twoThreeTree.insert(110);
        twoThreeTree.insert(120);
        twoThreeTree.insert(130);
        twoThreeTree.insert(140);
        twoThreeTree.insert(150);

        twoThreeTree.remove(80);
    }
}
