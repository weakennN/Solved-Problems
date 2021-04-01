package Generics.GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {


    public T[] create(int length, T item) {
        Object array = Array.newInstance(item.getClass(), length);

        T[] arr = (T[]) array;
        for (int i = 0; i < length; i++) {
            arr[i] = item;
        }

        return arr;
    }

    public T[] create(Class<T> clazz, int length, T item) {

        return create(length, item);
    }
}
