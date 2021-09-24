package DataStructure.LinearDataStructure.ArrayDeque;

public class ArrayDeque<E> {

    private final int DEFAULT_CAPACITY = 7;
    private int head;
    private int tail;
    private int size;

    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.elements.length / 2;
        this.tail = this.head;
    }

    public void add(E element) {
        if (this.size == 0) {
            this.elements[this.head] = element;
        } else {
            if (this.head >= this.elements.length - 1) {
                this.grow();
            }
            this.elements[++this.head] = element;
        }

        this.size++;
    }

    public void offer(E element) {
        if (this.size == 0) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail <= 0) {
                this.grow();
            }
            this.elements[--this.tail] = element;
        }

        this.size++;
    }

    private void grow() {
        Object[] newElements = new Object[this.elements.length * 2 + 1];

        int middle = newElements.length / 2;
        int begin = middle - (this.size / 2);
        int index = this.tail;

        for (int i = begin; index <= this.head; i++) {
            newElements[i] = this.elements[index++];
        }

        this.elements = newElements;
        this.tail = begin;
        this.head = begin + this.size - 1;
    }

    public void addFirst(E element) {
        this.offer(element);
    }

    public void addLast(E element) {
        this.add(element);
    }

    public void push(E element) {
        this.add(element);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public E get(int index) {
        this.checkIndex(index);
        int realIndex = this.tail + index;

        return this.castElement(realIndex);
    }

    public void set(int index, E element) {
        this.checkIndex(index);
        int realIndex = this.tail + index;
        this.elements[realIndex] = element;
    }

    public E peek() {
        if (this.size <= 0) {
            return null;
        }

        return castElement(this.head);
    }

    public E poll() {
        if (this.size <= 0) {
            return null;
        }

        E element = castElement(this.head);
        this.elements[this.head] = null;
        this.head--;
        this.size--;

        return element;
    }

    public E pop() {
        return this.poll();
    }

    public E remove(int index) {
        this.checkIndex(index);
        int realIndex = this.tail + index;
        E element = this.castElement(realIndex);
        this.elements[realIndex] = null;
        this.removeShift(realIndex);
        this.size--;

        return element;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E element = castElement(this.tail);
        this.elements[this.tail] = null;
        if (this.tail != this.head) {
            this.tail++;
        }
        this.size--;

        return element;
    }

    public E removeLast() {
        return this.poll();
    }

    public void insert(int index, E element) {
        this.checkIndex(index);

        if (this.head + 1 >= this.elements.length - 1
                || this.tail - 1 < 0) {
            this.grow();
        }

        int realIndex = 0;

        if (index >= this.size / 2) {
            realIndex = (this.tail - 1) + index;
            this.shiftLeft(realIndex);

        } else {
            realIndex = this.tail + index;
            this.shiftRight(realIndex);
        }

        this.elements[realIndex] = element;
        this.size++;
    }

    private void shiftRight(int index) {
        for (int i = this.head; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[index] = null;
        this.head++;
    }

    private void shiftLeft(int index) {
        for (int i = this.tail; i <= index; i++) {
            this.elements[i - 1] = this.elements[i];
        }

        this.elements[index] = null;
        this.tail--;
    }

    private void checkIndex(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + this.size);
        }
    }

    @SuppressWarnings("unchecked")
    private E castElement(int index) {
        return (E) this.elements[index];
    }

    private void removeShift(int index) {
        for (int i = index; i < this.head; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.head--] = null;
    }
}
