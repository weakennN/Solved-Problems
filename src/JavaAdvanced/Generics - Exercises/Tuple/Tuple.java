package Generics.Tuple;

public class Tuple<T> {

    private T item1;
    private T item2;

    public Tuple(T item1, T item2) {

        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.item1, this.item2);
    }
}
