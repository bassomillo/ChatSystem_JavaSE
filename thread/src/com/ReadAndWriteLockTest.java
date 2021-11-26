package com;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockTest {
    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static int count = 1;

    public static void main(String[] args) {
        Runnable read = ()->{
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
            readLock.lock();
            try {
                ThreadUtils.sleep(1000);
                System.out.println("I am reading "+ count);
            }finally {
                readLock.unlock();
            }
        };

        Runnable write = ()->{
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            writeLock.lock();
            try {
                ThreadUtils.sleep(1000);
                System.out.println("I am writing " + count+1);
            }finally {
                writeLock.unlock();
            }
        };

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int flag = random.nextInt(100);
            if(flag>20){
                new Thread(read,"read").start();
            }else {
                new Thread(write,"write").start();
            }
        }
    }
}
