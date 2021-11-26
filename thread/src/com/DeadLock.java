package com;

public class DeadLock {
    private static final Object MONITOR1 = new Object();
    private static final Object MONITOR2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (MONITOR1){
                System.out.println(Thread.currentThread().getName()+" got MONITOR1");
                ThreadUtils.sleep(100);
                synchronized (MONITOR2){
                    System.out.println(Thread.currentThread().getName()+" got MONITOR2");
                }
            }
        },"Thread1").start();

        new Thread(()->{
            synchronized (MONITOR2){
                System.out.println(Thread.currentThread().getName()+" got MONITOR2");
                ThreadUtils.sleep(100);
                synchronized (MONITOR1){
                    System.out.println(Thread.currentThread().getName()+" got MONITOR1");
                }
            }
        },"Thread2").start();
    }
}
