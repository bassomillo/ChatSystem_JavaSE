package com;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            ThreadUtils.sleep(1000);
            System.out.println("this is t1");
        });
        Thread t2 = new Thread(()->{
            ThreadUtils.sleep(2000);
            System.out.println("this is t2");
        });

        t1.start();
        t2.start();
        t1.join();
        System.out.println("This is main thread");
    }
}
