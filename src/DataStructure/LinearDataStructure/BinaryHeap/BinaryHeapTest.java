package DataStructure.LinearDataStructure.BinaryHeap;

public class BinaryHeapTest {

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(7);
        binaryHeap.insert(40);
        binaryHeap.insert(35);
        binaryHeap.insert(30);
        binaryHeap.insert(15);
        binaryHeap.insert(10);
        binaryHeap.insert(25);
        binaryHeap.insert(5);

        while (!binaryHeap.isEmpty()) {
            binaryHeap.remove();
        }

        binaryHeap.insert(40);
        binaryHeap.insert(35);
        binaryHeap.insert(30);
        binaryHeap.insert(15);
        binaryHeap.insert(10);
        binaryHeap.insert(25);
        binaryHeap.insert(5);
    }
}
