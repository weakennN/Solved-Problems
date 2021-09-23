package DataStructure.LinearDataStructure.ArrayDeque;


public class ArrayDequeTest {

    public static void main(String[] args) {

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            arrayDeque.add(i);
        }

        for (int i = 0; i < arrayDeque.size(); i++) {
            System.out.println(arrayDeque.get(i));
        }

        System.out.println(arrayDeque.peek());
    }
}
