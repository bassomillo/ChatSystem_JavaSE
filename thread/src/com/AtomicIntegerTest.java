package com;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(()->{
                ThreadUtils.sleep(20);
                atomicInteger.getAndIncrement();
            }).start();
        }
        ThreadUtils.sleep(2000);
        System.out.println(atomicInteger.get());
    }
}
