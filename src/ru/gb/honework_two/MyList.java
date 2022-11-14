package ru.gb.honework_two;

import java.util.Iterator;

public interface MyList<T> extends Iterable<T>{
    boolean add(T element);
    boolean set(int index, T element);
    void clear();
    T get (int index);
    int size();
    T remove(int index);

}
