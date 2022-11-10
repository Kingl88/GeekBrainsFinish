package ru.gb.honework_two.linked_list;

import ru.gb.honework_two.MyList;

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> first;
    private int size;

    public MyLinkedList() {
    }

    @Override
    public boolean add(T element) {
        if (first == null) {
            first = new Node<>(element, null);
            size++;
            return true;
        } else {
            findNode(first).next = new Node<>(element, null);
            size++;
        }
        return true;
    }

    private Node<T> findNode(Node<T> start) {
        if (start.next == null) {
            return start;
        } else {
            return findNode(start.next);
        }
    }

    @Override
    public boolean set(int index, T element) {
        if(index > size){
            throw new IndexOutOfBoundsException("Размер списка = " + size + " индекс заменяемого элемента " + index);
        }
        int counter = 0;
        Node<T> temp = first;
        while (counter != index && temp.next != null) {
            temp = temp.next;
            counter++;
        }
        temp.value = element;
        return true;
    }

    @Override
    public void clear() {
        first.next = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if(size == 0){
            throw new IndexOutOfBoundsException("Список пуст");
        }
        if(index >= size){
            throw new IndexOutOfBoundsException("Размер списка = " + size + " индекс элемента " + index);
        }
        int counter = 0;
        Node<T> temp = first;
        while (counter != index && temp.next != null) {
            temp = temp.next;
            counter++;
        }

        return temp.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException("Размер списка = " + size + " индекс заменяемого элемента " + index);
        }
        int counter = 0;
        Node<T> temp = first;
        while (counter != index - 1 && temp.next.next != null) {
            temp = temp.next;
            counter++;
        }
        T tempValue = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return tempValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }
    private class Iter implements Iterator<T>{
        private Node<T> temp;

        public Iter() {
            this.temp = first;
        }

        @Override
        public boolean hasNext() {
            return Objects.nonNull(temp);
        }

        @Override
        public T next() {
            T tempElement = temp.value;
            temp = temp.next;
            return tempElement;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<T> temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.next == null) {
                builder.append(temp.value).append("]");
            } else {
                builder.append(temp.value).append(", ");
                temp = temp.next;
            }
        }
        return builder.toString();
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
