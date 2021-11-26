package com;

//Interrupt() is an instance method and i can interrupt wait and sleep
// but cannot interrupt a thread which is working.
public class InterruptTest2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 started");
            synchronized (InterruptTest2.class) {
                try {
                    InterruptTest2.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            ThreadUtils.sleep(600000000);
            System.out.println("Thread1 dead");
        });
        t1.start();
        ThreadUtils.sleep(1000);
        t1.interrupt();
    }
}
