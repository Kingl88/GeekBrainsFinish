package ru.gb.honework_two.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.honework_two.linked_list.MyLinkedList;

import java.util.Iterator;

class MyLinkedListTest {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    @BeforeEach
    public void fillList(){
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
    }

    @Test
    void set() {
        list.set(10, 100);
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->list.set(100, 100));
        Assertions.assertEquals(100, list.get(10));

    }

    @Test
    void clear() {
        list.clear();
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->list.get(0));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void get() {
        Assertions.assertEquals(15, list.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->list.get(15));
        Assertions.assertEquals(3, list.get(3));
    }

    @Test
    void size() {
        Assertions.assertEquals(15, list.size());
    }

    @Test
    void remove() {
        list.remove(10);
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->list.remove(14));
    }

    @Test
    void iterator() {

        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while(iterator.hasNext()){
            Integer temp = iterator.next();
            Assertions.assertEquals(i++, temp);
        }
    }
}