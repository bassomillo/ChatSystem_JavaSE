package com;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("1");
            ThreadUtils.sleep(1000);
            System.out.println("2");
            LockSupport.park();
            System.out.println("3");
        });

        thread.start();
        ThreadUtils.sleep(2000);
        System.out.println("2s passed");
        LockSupport.unpark(thread);
    }
}
