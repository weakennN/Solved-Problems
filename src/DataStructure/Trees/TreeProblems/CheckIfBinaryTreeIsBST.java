package DataStructure.Trees.BinarySearchTree;

public class CheckIfBinaryTreeIsBST {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(9);
        root.setLeft(new Node<>(7));
        root.setRight(new Node<>(11));
        root.getLeft().setRight(new Node<>(8));
        root.getLeft().getRight().setLeft(new Node<>(1));
        System.out.println(checkIfTreeIsCorrect(root));
    }

    private static boolean checkIfTreeIsCorrect(Node<Integer> node) {
        if (node == null) {
            return true;
        }

        if (!checkIfTreeIsCorrect(node.getLeft())) {
            return false;
        }
        int leftMaxValue = getMaxValue(node.getLeft());
        if (!checkIfTreeIsCorrect(node.getRight())) {
            return false;
        }
        int rightMaxValue = getMinValue(node.getRight());

        if (leftMaxValue < node.getElement() && rightMaxValue > node.getElement()) {
            return true;
        }

        return false;
    }

    private static int getMinValue(Node<Integer> node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int left = getMinValue(node.getLeft());
        int right = getMinValue(node.getRight());

        if (left == right && node.getElement() < left
                && node.getElement() < right) {
            return node.getElement();
        } else if (left < right && left < node.getElement()) {
            return left;
        }

        return right;
    }

    private static int getMaxValue(Node<Integer> node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int left = getMaxValue(node.getLeft());
        int right = getMaxValue(node.getRight());

        if (left == right && node.getElement() > left
                && node.getElement() > right) {
            return node.getElement();
        } else if (left > right && left > node.getElement()) {
            return left;
        }

        return right;
    }
}
