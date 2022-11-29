package ru.gb.homework_three;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static int count = 0;
    private static final int numberOfThread = 5;

    private static final int finalCount = 1000;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < numberOfThread; i++) {
            threadList.add(new Thread(()->{
                for (int j = 0; j < finalCount / numberOfThread; j++) {
                    lock.lock();
                    count++;
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    lock.unlock();
                }
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println("Count = " + count);
    }
}
