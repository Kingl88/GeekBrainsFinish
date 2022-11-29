package ru.gb.honework_two.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.honework_two.array_list.MyArrayList;

import java.util.Iterator;

class MyArrayListTest {

    MyArrayList<Integer> list = new MyArrayList<>();

    @BeforeEach
    public void fillList(){
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
    }

    @Test
    void addAndGet() {
        Assertions.assertEquals(0, list.get(0));
        Assertions.assertEquals(1, list.get(1));
        Assertions.assertEquals(2, list.get(2));
        Assertions.assertEquals(3, list.get(3));
        Assertions.assertEquals(14, list.get(14));
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->list.get(100));
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->list.get(-100));
    }

    @Test
    void set() {
        list.set(10, 100);
        Assertions.assertEquals(100, list.get(10));
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->list.set(100, 100));
    }

    @Test
    void clear() {
        list.clear();
        Assertions.assertEquals(0, list.size());
        Assertions.assertNull(list.get(0));
    }

    @Test
    void size() {
        Assertions.assertEquals(15, list.size());
    }

    @Test
    void remove() {
        Assertions.assertEquals(2, list.remove(2));
        Assertions.assertEquals(3, list.get(2));
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