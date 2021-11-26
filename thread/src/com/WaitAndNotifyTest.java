package com;

public class WaitAndNotifyTest {
    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (MONITOR){
                System.out.println("Thread1 started");
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 is dead");
            }
        }).start();

        new Thread(()->{
            synchronized (MONITOR){
                System.out.println("Thread2 started");
                ThreadUtils.sleep(2000);
                MONITOR.notify();
                System.out.println("Thread2 is dead");
            }
        }).start();
    }
}
