package DataStructure.LinearDataStructure.ArrayDeque;


public class ArrayDequeTest {

    public static void main(String[] args) {

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            arrayDeque.add(i);
        }

        arrayDeque.remove(7);
    }
}
