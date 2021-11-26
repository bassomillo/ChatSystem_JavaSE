package com;

public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 started");
            ThreadUtils.sleep(600000000);
            System.out.println("Thread1 dead");
        });
        t1.start();
        ThreadUtils.sleep(1000);
        t1.interrupt();

    }
}
