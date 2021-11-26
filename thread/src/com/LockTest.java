package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static final Object MONITOR = new Object();

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
               lock.lock();
               try {
                   System.out.println(Math.random());
                   System.out.println("-------------------");
               }finally {
                   lock.unlock();
               }


            }).start();


        }
    }
}
