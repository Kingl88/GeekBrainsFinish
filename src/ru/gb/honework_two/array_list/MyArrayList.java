package ru.gb.honework_two.array_list;

import ru.gb.honework_two.MyList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private Object [] array;
    private int capacity;
    private int size;

    public MyArrayList() {
        this.capacity = 10;
        this.array = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }


    @Override
    public boolean add(T element) {
        if(size == 0){
            array[0] = element;
            size++;
            return true;
        } else if(size == capacity){
            capacity = capacity * 2 + 1;
            array = Arrays.copyOf(array, capacity);
            add(element);
            return true;
        }

        for (int i = 0; i < capacity; i++) {
            if (Objects.isNull(array[i])){
                array[i] = element;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, T element) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Размер списка = " + size + " индекс заменяемого элемента " + index);
        }
        for (int i = 0; i < capacity; i++) {
            if(i == index){
                array[i] = element;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;

    }
    @Override
    public T get(int index) {
        if(size < 1){
            return null;
        }
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Размер списка = " + size + " индекс искомого элемента " + index);
        } else return (T) array[index];

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T remove(int index) {
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Размер списка = " + size + " индекс искомого элемента " + index);
        }
        Object tempElement = array[index];
        Object[] tempArray2 = Arrays.copyOfRange(array, index + 1, size);
        System.arraycopy(tempArray2, 0, array, index, size -(index + 1));
        array[size - 1] = null;
        size--;

        return (T) tempElement;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {

            if (i == size - 1){
                builder.append(array[i]).append("]");
            } else {
                builder.append(array[i]).append(", ");
            }
        }
        return builder.toString();
    }

    private class ArrayIterator implements Iterator<T>{
        int position = 0;
        @Override
        public boolean hasNext() {
            return position < size && array[position] != null;
        }

        @Override
        public T next() {
            Object temp = array[position];
            position++;
            return (T) temp;
        }
    }
}
